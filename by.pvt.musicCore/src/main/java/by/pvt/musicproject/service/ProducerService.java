package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.ProducerRequest;
import by.pvt.musicproject.dto.ProducerResponse;
import by.pvt.musicproject.entity.Producer;

import java.util.List;
import java.util.Optional;

public interface ProducerService {
    public ProducerResponse add(ProducerRequest producerRequest);

    public ProducerResponse findProducerById(Long id);

    public void deleteProducer(Long id);


    public List<ProducerResponse> getAllProducer();
}
