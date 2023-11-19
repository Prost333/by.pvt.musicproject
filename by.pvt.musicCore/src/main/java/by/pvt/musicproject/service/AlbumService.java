package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.AlbumsReq;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    AlbumsRes add(AlbumsReq album);

    AlbumsRes findAlbumById(Long id);

    void deleteAlbum(Long id);

    void addEntity(Album album);
    List<AlbumsRes> getAllAlbum();

    List<AlbumsRes> findByName(String name);

    Map<AlbumsRes, List<TrackRes>> addTrackToAlbum(Long id, Long trackid);
    Album findEntityById(Long id);
    Page<Album> getAllAlbumPage(int page, int size);
    List<Album> findEntityByName(String name);
    List<AlbumsRes> findByPerformer(Performer performer);
}
