package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.mapper.UserMapping;
import by.pvt.musicproject.repository.dao.DaoPerformer;
import by.pvt.musicproject.repository.dao.DaoProducer;
import by.pvt.musicproject.service.PerformerService;

import java.util.List;

public class PerformerServiceImp implements PerformerService {
    private final DaoPerformer dao;

    public PerformerServiceImp(DaoPerformer dao) {
        this.dao = dao;
    }

    @Override
    public void add(Performer performer) {
        dao.add(performer);
    }

    @Override
    public Performer findPerformerById(Long id) {
        return dao.findPerformerById(id);
    }

    @Override
    public Performer findPerformerByName(String name) {
        return dao.findPerformerByName(name);
    }

    @Override
    public void deletePerformer(Long id) {
        dao.deletePerformer(id);
    }

    @Override
    public List<Performer> getAllPerformer() {
        return dao.getAllPerformer();
    }

    @Override
    public List<Performer> detachCriteria(String name) {
        return dao.detachCriteria(name);
    }
}
