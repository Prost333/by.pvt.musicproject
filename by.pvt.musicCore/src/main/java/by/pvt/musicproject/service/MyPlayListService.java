package by.pvt.musicproject.service;

import by.pvt.musicproject.entity.MyPlayList;
import by.pvt.musicproject.entity.TrackList;

import java.util.List;

public interface MyPlayListService {
    Long add(MyPlayList myPlayList);

    MyPlayList findPlayListById(Long id);

    void deletePlayList(Long id);

    void updateMyTrackList(List<Long> track, Long playList);

    List<MyPlayList> getAllPlayList();

    void addTrackToPlaylist(Long trackid, Long playlistid);

    List<TrackList> findTrackByName(String name, Long playlistid);
}
