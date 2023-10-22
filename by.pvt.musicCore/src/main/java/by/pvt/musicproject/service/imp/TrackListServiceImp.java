package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.repository.dao.DaoTrackList;
import by.pvt.musicproject.service.TrackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackListServiceImp {
    @Autowired
    private  DaoTrackList dao;



    public Track add(Track track) {
        return dao.save(track);
    }


    public Track findTrackById(Long id) {
        Optional<Track> track = Optional.of(dao.findById(id).orElseThrow());
        return track.get();
    }


    public void deleteTrackList(Track track) {
        dao.delete(track);
    }


    public List<Track> getAllList() {
        return dao.findAll();
    }
    List<Track> findByStyle(String style){
        return dao.findByStyle(style);
    }
    List<Track> findByPerformer(Performer performer){
        return dao.findByPerformer(performer);
    }

    List<Track> findByAlbums(Album album){
        return dao.findByAlbums(album);
    }
    List<Track> findByName(String name){
        return  dao.findByName(name);
    }

//    List<String> findAllByFile(){
//        return  dao.findAllByFile();
//    }



}
