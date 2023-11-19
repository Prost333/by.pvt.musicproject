package by.pvt.musicproject.controller;

import by.pvt.musicproject.dto.*;
import by.pvt.musicproject.mapper.ProducerMapping;
import by.pvt.musicproject.service.AmountService;
import by.pvt.musicproject.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producer")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;
    private final AmountService amountService;
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
    @PostMapping("/createAmount")
    public AmountRes createAmount(@RequestBody AmountReq amountReq){
        return amountService.add(amountReq);
    }
    @GetMapping("/deleteAmount")
    public void createAmount(@RequestParam("id") Long id){
        amountService.delete(id);
    }

    @GetMapping()
    public ProducerResponse getById(@RequestParam("id") Long id) {
        return producerService.findProducerById(id);
    }
}
