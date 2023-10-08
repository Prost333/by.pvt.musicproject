package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.repository.dao.DaoTrackList;
import by.pvt.musicproject.service.TrackListService;

import java.util.List;

public class TrackListServiceImp implements TrackListService {
    private final DaoTrackList dao;

    public TrackListServiceImp(DaoTrackList dao) {
        this.dao = dao;
    }

    @Override
    public Long add(Track track) {
        return dao.add(track);
    }

    @Override
    public Track findTrackById(Long id) {
        return dao.findTrackById(id);
    }

    @Override
    public void deleteTrackList(Long id) {
        dao.deleteTrackList(id);
    }

    @Override
    public List<Track> getAllList() {
        return dao.getAllList();
    }

    @Override
    public List<Track> getTrackByStyle(String style) {
        return dao.getTrackByStyle(style);
    }

    @Override
    public List<Track> findAllByPerformer(Long performer) {
        return dao.findAllByPerformer(performer);
    }

    @Override
    public List<Track> findAllByAlbums(Long album) {
        return dao.findAllByAlbums(album);
    }

    @Override
    public List<Track> findByName(String name) {
        return dao.findByName(name);
    }

    public void updateTrack(Track track) {
        dao.updateTrack(track);
    }

    @Override
    public List<Track> findTrackByPerformer(Long id) {
        return dao.findAllByPerformer(id);
    }

    @Override
    public List<Track> findUserPlayList(Long id) {
        return dao.findUserPlayList(id);
    }

    public List<String> getAllFile() {
        return dao.getAllFile();
    }

}
