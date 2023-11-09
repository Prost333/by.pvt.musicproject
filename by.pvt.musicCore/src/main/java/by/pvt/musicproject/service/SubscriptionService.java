package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.SubscriptionRes;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface SubscriptionService {
    void add(Subscription subscription);

    Subscription findSubscriptionById(Long id);

    void deleteSubscription(Subscription subscription);

    void deleteSubscriptionById(Long id);

    List<Subscription> getAllSubscription();

    void calculateTimeDifference(LocalDateTime end);

    Subscription defaultSubscription();

    Subscription subByProducer(Producer producer);

}
