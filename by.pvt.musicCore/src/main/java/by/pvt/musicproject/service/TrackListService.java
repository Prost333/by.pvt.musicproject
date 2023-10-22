package by.pvt.musicproject.service;

import by.pvt.musicproject.entity.Track;

import java.util.List;

public interface TrackListService {
    Track add(Track track);

    Track findTrackById(Long id);

    void deleteTrackList(Track track);

    List<Track> getAllList();

    List<Track> getTrackByStyle(String style);

    List<Track> findAllByPerformer(Long performer);

    List<Track> findAllByAlbums(Long album);

    List<Track> findByName(String name);

    void updateTrack(Track track);

    List<Track> findTrackByPerformer(Long id);

    List<Track> findUserPlayList(Long id);

    List<String> getAllFile();


}
