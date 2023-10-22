package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.dao.DaoProducer;
import by.pvt.musicproject.repository.dao.DaoUser;
import by.pvt.musicproject.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerServiceImp  {
    @Autowired
    private DaoProducer dao;


    public void add(Producer producer) {
        dao.save(producer);
    }

    public Producer findProducerById(Long id) {
        Optional<Producer> user = Optional.of(dao.findById(id).orElseThrow());
        return user.get();
    }

    public void deleteProducer(Producer producer) {
        dao.delete(producer);
    }


    public List<Producer> getAllProducer() {
        return dao.findAll();
    }
}
