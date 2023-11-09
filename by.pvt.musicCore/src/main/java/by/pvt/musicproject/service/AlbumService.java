package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.AlbumsReq;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Track;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AlbumService {
    AlbumsRes add(AlbumsReq album);

    AlbumsRes findAlbumById(Long id);

    void deleteAlbum(Long id);

    void addEntity(Album album);
    List<AlbumsRes> getAllAlbum();

    List<Album> findByName(String name);

    Album addTrackToAlbum(Long id, Track track);
    Album findEntityById(Long id);
    Page<Album> getAllAlbumPage(int page, int size);

}
