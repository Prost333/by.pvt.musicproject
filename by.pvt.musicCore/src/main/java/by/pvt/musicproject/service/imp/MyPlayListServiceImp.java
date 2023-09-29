package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.MyPlayList;
import by.pvt.musicproject.entity.TrackList;
import by.pvt.musicproject.repository.dao.DaoMyPlayList;
import by.pvt.musicproject.repository.TrackListRepository;
import by.pvt.musicproject.service.MyPlayListService;

import java.util.List;

public class MyPlayListServiceImp implements MyPlayListService {
    private final DaoMyPlayList dao;
    private TrackListRepository trackListRepository=new TrackListRepository();

    public MyPlayListServiceImp(DaoMyPlayList dao) {
        this.dao = dao;
    }

    @Override
    public Long add(MyPlayList myPlayList) {
        return dao.add(myPlayList);
    }

    @Override
    public MyPlayList findPlayListById(Long id) {
        return dao.findPlayListById(id);
    }

    @Override
    public void deletePlayList(Long id) {
        dao.deletePlayList(id);
    }

    @Override
    public List<MyPlayList> getAllPlayList() {
        return dao.getAllPlayList();
    }


    public void updateMyTrackList(List<Long>track, Long playList){
        List<TrackList> trackLists=trackListRepository.findAllByIds(track);
        MyPlayList myPlayList=findPlayListById(playList);
        trackLists.forEach(trackList -> trackList.setMyPlayListListId(List.of(myPlayList)));
        myPlayList.setTrack(trackLists);
        dao.updatePlayList(myPlayList);
        trackLists.forEach(trackListRepository::updateTrack);
    }

    public void addTrackToPlaylist(Long trackid, Long playlistid){
        dao.addTrackToPlaylist(trackid,playlistid);
    }

    @Override
    public List<TrackList> findTrackByName(String name, Long playlistid) {
        return dao.findTrackByName(name,playlistid);
    }


}
