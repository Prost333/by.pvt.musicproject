package by.pvt.musicproject.controller;

import by.pvt.musicproject.dto.ProducerRequest;
import by.pvt.musicproject.dto.ProducerResponse;
import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.mapper.ProducerMapping;
import by.pvt.musicproject.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producer")
public class ProducerController {
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ProducerMapping producerMapping;
    @GetMapping("/getAll")
    public List<ProducerResponse> findAll() {
        return producerService.getAllProducer();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        producerService.deleteProducer(id);
    }

    @PostMapping
    public ProducerResponse add(@RequestBody @Validated ProducerRequest producerRequest) {
        return producerService.add(producerRequest);
    }

    @GetMapping()
    public ProducerResponse getById(@RequestParam("id") Long id) {
        return producerService.findProducerById(id);
    }
}
