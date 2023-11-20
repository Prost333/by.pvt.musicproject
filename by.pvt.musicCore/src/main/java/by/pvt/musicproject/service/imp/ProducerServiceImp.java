package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.ProducerRequest;
import by.pvt.musicproject.dto.ProducerResponse;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.exception.EntityNotFoundException;
import by.pvt.musicproject.mapper.ProducerMapping;
import by.pvt.musicproject.repository.DaoProducer;
import by.pvt.musicproject.service.ProducerService;
import by.pvt.musicproject.service.SubscriptionService;
import by.pvt.musicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerServiceImp implements ProducerService {

    private final DaoProducer dao;

    private final ProducerMapping producerMapping;
    private final SubscriptionService subscriptionService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ProducerResponse add(ProducerRequest producerRequest) {
        Producer producer = producerMapping.toEntity(producerRequest);
        producer.setPassword(passwordEncoder.encode(producer.getPassword()));
        dao.save(producer);
        producer.setSubscription(subscriptionService.subByProducer(producer));
        producer.setRole("ADMIN");
        dao.save(producer);
        return producerMapping.toResponse(producer);
    }

    public ProducerResponse findProducerById(Long id) {
        Producer user = dao.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
        return producerMapping.toResponse(user);
    }

    public void deleteProducer(Long id) {
        dao.deleteById(id);
    }


    public List<ProducerResponse> getAllProducer() {
        return dao.findAll().stream().map(producer -> producerMapping.toResponse(producer)).collect(Collectors.toList());
    }
}
