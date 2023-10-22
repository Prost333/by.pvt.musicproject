package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.repository.DaoAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImp {
    @Autowired
    private DaoAlbum daoAlbum;

    public AlbumServiceImp(DaoAlbum daoAlbum) {
        this.daoAlbum = daoAlbum;
    }


    public void add(Album album) {
        daoAlbum.save(album);
    }


    public Album findAlbumById(Long id) {
        Optional<Album> album = Optional.of(daoAlbum.findById(id).orElseThrow());
        return album.get();
    }

    public void deleteAlbum(Album album) {
        daoAlbum.delete(album);
    }


    public List<Album> getAllPerformer() {
        return daoAlbum.findAll();
    }

    public List<Album> findByName(String name) {
        return (List<Album>) daoAlbum.findByName(name);
    }
    public Album addTrackToAlbum(Long id, Track track) {
       Album album = daoAlbum.findById(id).orElse(null);
        if (album != null) {
            album.getTrack().add(track);
            return daoAlbum.save(album);
        } else {
            return null;
        }}


}
