package by.pvt.musicproject.service;

import by.pvt.musicproject.entity.Producer;

import java.util.List;

public interface ProducerService {
    void add (Producer producer);
    Producer findProducerById(Long id);
    void deleteProducer(Long id);
    List<Producer> getAllProducer();
}
