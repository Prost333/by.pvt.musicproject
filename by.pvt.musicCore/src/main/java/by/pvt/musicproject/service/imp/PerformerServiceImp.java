package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.dto.PerformersRes;
import by.pvt.musicproject.entity.*;
import by.pvt.musicproject.mapper.PerformerMapper;
import by.pvt.musicproject.repository.DaoPerformer;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerformerServiceImp implements PerformerService {
    @Autowired
    private DaoPerformer dao;
    @Autowired
    private PerformerMapper performerMapper;
    @Autowired
    private AlbumService albumService;

    @Autowired
    public PerformerServiceImp(DaoPerformer dao, PerformerMapper performerMapper) {
        this.dao = dao;
        this.performerMapper = performerMapper;
    }

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

    public Performer addAlbumToPerformer(Long performerId, Album album) {
        Performer performer = dao.findById(performerId).orElse(null);
        if (performer != null) {
            performer.getAlbum().add(album);
            album.setPerformer(performer);
            albumService.addEntity(album);
            return dao.save(performer);
        } else {
            return null;
        }
    }

    public Page<Performer> getAllPerformerPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return dao.findAll(pageable);
    }


}
