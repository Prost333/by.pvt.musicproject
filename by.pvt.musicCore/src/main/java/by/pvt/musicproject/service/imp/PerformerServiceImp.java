package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.*;
import by.pvt.musicproject.repository.dao.DaoPerformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformerServiceImp {

    private final DaoPerformer dao;

    @Autowired
    public PerformerServiceImp(DaoPerformer dao) {
        this.dao = dao;
    }


    public void add(Performer performer) {
        dao.save(performer);
    }


    public Performer findPerformerById(Long id) {
        Optional<Performer> performer = Optional.of(dao.findById(id).orElseThrow());
        return performer.get();
    }


    public List<Performer> findPerformerByName(String name) {
        return dao.findByName(name);
    }


    public void deletePerformer(Performer performer) {
        dao.delete(performer);
    }

    public List<Performer> getAllPerformer() {
        return dao.findAll();
    }

    public Page<Performer> findAllOrderById(Pageable pageable) {
        return findAllOrderById(pageable);
    }
    public Performer addAlbumToPerformer(Long performerId, Album album) {
        Performer performer = dao.findById(performerId).orElse(null);
        if (performer != null) {
            performer.getAlbum().add(album);
            return dao.save(performer);
        } else {

            return null;
        }}


}
