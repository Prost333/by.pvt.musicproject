package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.AlbumsReq;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.dto.PerformersRes;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.mapper.AlbumMapper;
import by.pvt.musicproject.repository.DaoAlbum;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.TrackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImp implements AlbumService {
    @Autowired
    private DaoAlbum daoAlbum;
    @Autowired
    private TrackListService trackListService;
    @Autowired
    private AlbumMapper albumMapper;


    public AlbumsRes add(AlbumsReq album) {
        Album album1 = albumMapper.toEntity(album);
        daoAlbum.save(album1);
        return albumMapper.toResponse(album1);
    }

    public Album findEntityById(Long id) {
        Optional<Album> album = Optional.of(daoAlbum.findById(id).orElseThrow());
        return album.get();
    }


    public AlbumsRes findAlbumById(Long id) {
        Optional<Album> album = Optional.of(daoAlbum.findById(id).orElseThrow());
        return albumMapper.toResponse(album.get());
    }

    public void deleteAlbum(Long id) {
        daoAlbum.deleteById(id);
    }

    @Override
    public void addEntity(Album album) {
        daoAlbum.save(album);
    }


    public List<AlbumsRes> getAllAlbum() {
        return daoAlbum.findAll().stream().map(album -> albumMapper.toResponse(album)).collect(Collectors.toList());
    }

    public List<AlbumsRes> findByName(String name) {
        return daoAlbum.findByName(name).stream().map(album -> albumMapper.toResponse(album)).collect(Collectors.toList());
    }

    public List<Album> findEntityByName(String name) {
        return daoAlbum.findByName(name);
    }

    @Override
    public List<AlbumsRes> findByPerformer(Performer performer) {
        return daoAlbum.findByPerformer(performer).stream().map(albumMapper::toResponse).collect(Collectors.toList());
    }

    public Map<AlbumsRes, List<TrackRes>> addTrackToAlbum(Long id, Long trackid) {
        Map<AlbumsRes, List<TrackRes>> map = new HashMap<>();
        Track track =trackListService.findTrackById(id);
        Album album = daoAlbum.findById(id).orElse(null);
        if (album != null) {
            album.getTrack().add(track);
            track.setAlbums(album);
            trackListService.addEntity(track);
            Album savedAlbum = daoAlbum.save(album);
            AlbumsRes albumsRes = albumMapper.toResponse(savedAlbum);
            List<TrackRes> trackRes = trackListService.findByAlbums(album);
            map.put(albumsRes, trackRes);
        }
        return map;
    }


    public Page<Album> getAllAlbumPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return daoAlbum.findAll(pageable);
    }


}
