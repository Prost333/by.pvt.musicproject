package by.pvt.musicproject.repository.dao;

import by.pvt.musicproject.entity.MyPlayList;
import by.pvt.musicproject.entity.TrackList;
import by.pvt.musicproject.entity.User;

import java.util.List;

public interface DaoMyPlayList {
    Long add(MyPlayList myPlayList);

    MyPlayList findPlayListById(Long id);

    void deletePlayList(Long id);

    List<MyPlayList> getAllPlayList();

    void updatePlayList(MyPlayList myPlayList);

    void addTrackToPlaylist(Long trackid, Long playlistid);

    List<TrackList> findTrackByName(String name, Long playlistid);
}
