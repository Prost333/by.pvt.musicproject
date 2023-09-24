package by.pvt.musicproject.repository.dao;

import by.pvt.musicproject.entity.Producer;

import java.util.List;

public interface DaoProducer {
    void add(Producer producer);

    Producer findProducerById(Long id);

    void deleteProducer(Long id);

    List<Producer> getAllProducer();
}
