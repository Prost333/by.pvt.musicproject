package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.repository.DaoTrackList;
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
    public List<Track> findByStyle(String style){
        return dao.findByStyle(style);
    }
    public List<Track> findByPerformer(Performer performer){
        return dao.findByPerformer(performer);
    }

    public List<Track> findByAlbums(Album album){
        return dao.findByAlbums(album);
    }
    public List<Track> findByName(String name){
        return  dao.findByName(name);
    }

    public List<String> findAllByFile(){
            List<Track> tracks = dao.findAll();
            return tracks.stream()
                    .map(Track::getFile)
                    .toList();
        }



}
