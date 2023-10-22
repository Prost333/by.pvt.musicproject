package by.pvt.musicproject.service;

import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;

import java.util.List;

public interface AlbumService {
    void add(Album album);

    Album findAlbumById(Long id);

    Album findAlbumByName(String name);

    void deleteAlbum(Long id);

    List<Album> getAllPerformer();
    List<Album> detachCriteria(String name);
}
