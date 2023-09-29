package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.TrackList;
import by.pvt.musicproject.repository.dao.DaoTrackList;
import by.pvt.musicproject.service.TrackListService;

import java.util.List;

public class TrackListServiceImp implements TrackListService {
    private final DaoTrackList dao;

    public TrackListServiceImp(DaoTrackList dao) {
        this.dao = dao;
    }

    @Override
    public Long add(TrackList trackList) {
        return dao.add(trackList);
    }

    @Override
    public TrackList findTrackById(Long id) {
        return dao.findTrackById(id);
    }

    @Override
    public void deleteTrackList(Long id) {
        dao.deleteTrackList(id);
    }

    @Override
    public List<TrackList> getAllList() {
        return dao.getAllList();
    }

    @Override
    public List<TrackList> getTrackByStyle(String style) {
        return dao.getTrackByStyle(style);
    }

    @Override
    public List<TrackList> findAllByPerformer(Long performer) {
        return dao.findAllByPerformer(performer);
    }

    @Override
    public List<TrackList> findAllByAlbums(Long album) {
        return dao.findAllByAlbums(album);
    }

    @Override
    public List<TrackList> findByName(String name) {
        return dao.findByName(name);
    }
}
