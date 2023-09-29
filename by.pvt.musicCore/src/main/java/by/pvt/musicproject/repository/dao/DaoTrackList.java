package by.pvt.musicproject.repository.dao;

import by.pvt.musicproject.entity.TrackList;

import java.util.List;

public interface DaoTrackList {
    Long add(TrackList trackList);

    TrackList findTrackById(Long id);

    void deleteTrackList(Long id);

    List<TrackList> getAllList();

    List<TrackList> getTrackByStyle(String style);
    List<TrackList> findAllByPerformer(Long performer);
    List<TrackList> findAllByAlbums(Long album);
    List<TrackList> findByName(String name);
}
