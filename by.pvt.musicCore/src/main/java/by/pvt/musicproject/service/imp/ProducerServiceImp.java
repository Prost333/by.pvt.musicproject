package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.mapper.UserMapping;
import by.pvt.musicproject.repository.dao.DaoProducer;
import by.pvt.musicproject.repository.dao.DaoUser;
import by.pvt.musicproject.service.ProducerService;

import java.util.List;

public class ProducerServiceImp implements ProducerService {
    private final DaoProducer dao;
    private UserMapping userMapping;

    public ProducerServiceImp(DaoProducer dao) {
        this.dao = dao;
    }

    @Override
    public void add(Producer producer) {
        dao.add(producer);
    }

    @Override
    public Producer findProducerById(Long id) {
        return dao.findProducerById(id);
    }

    @Override
    public void deleteProducer(Long id) {
        dao.deleteProducer(id);
    }

    @Override
    public List<Producer> getAllProducer() {
        return dao.getAllProducer();
    }
}
