package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.dto.PerformersRes;
import by.pvt.musicproject.entity.*;
import by.pvt.musicproject.mapper.AlbumMapper;
import by.pvt.musicproject.mapper.PerformerMapper;
import by.pvt.musicproject.repository.DaoPerformer;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.PerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerformerServiceImp implements PerformerService {

    private final DaoPerformer dao;

    private final PerformerMapper performerMapper;
    private final AlbumMapper albumMapper;

    private final AlbumService albumService;

    @Transactional
    public PerformersRes add(PerformersReq performersReq) {
        Performer performer = performerMapper.toEntity(performersReq);
        dao.save(performer);
        return performerMapper.toResponse(performer);
    }


    public PerformersRes findPerformerById(Long id) {
        Optional<Performer> performer = Optional.of(dao.findById(id).orElseThrow());
        return performerMapper.toResponse(performer.get());

    }

    public List<Performer> findPerformerEntityByName(String name) {
        return dao.findByName(name);
    }

    public List<PerformersRes> findPerformerByName(String name) {
        return dao.findByName(name).stream().map(performer -> performerMapper.toResponse(performer)).collect(Collectors.toList());
    }


    public void deletePerformer(Long id) {
        dao.deleteById(id);
    }

    public List<PerformersRes> getAllPerformer() {
        return dao.findAll().stream().map(performer -> performerMapper.toResponse(performer)).toList();
    }

    public Map<PerformersRes, List<AlbumsRes>> addAlbumToPerformer(Long performerId, Long albumId) {
        Map<PerformersRes, List<AlbumsRes>> map = new HashMap<>();
        Album album = albumService.findEntityById(albumId);
        Performer performer = dao.findById(performerId).orElse(null);
        if (performer != null) {
            performer.getAlbum().add(album);
            album.setPerformer(performer);
            albumService.addEntity(album);
            Performer savedPerformer = dao.save(performer);

            PerformersRes performersRes = performerMapper.toResponse(savedPerformer);
            List<AlbumsRes> albumsResList = albumService.findByPerformer(performer);


            map.put(performersRes, albumsResList);
        }
        return map;
    }


    public Page<Performer> getAllPerformerPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return dao.findAll(pageable);
    }


}
