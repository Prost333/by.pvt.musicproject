package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.AlbumsReq;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.mapper.AlbumMapper;
import by.pvt.musicproject.repository.DaoAlbum;
import by.pvt.musicproject.service.AlbumService;
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
public class AlbumServiceImp implements AlbumService {
    @Autowired
    private DaoAlbum daoAlbum;
    @Autowired
    private AlbumMapper albumMapper;

    public AlbumServiceImp(DaoAlbum daoAlbum) {
        this.daoAlbum = daoAlbum;
    }


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

    public List<Album> findByName(String name) {
        return daoAlbum.findByName(name);
    }

    public Album addTrackToAlbum(Long id, Track track) {
        Album album = daoAlbum.findById(id).orElse(null);
        if (album != null) {
            album.getTrack().add(track);
            return daoAlbum.save(album);
        } else {
            return null;
        }
    }
    public Page<Album> getAllAlbumPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return daoAlbum.findAll(pageable);
    }


}
