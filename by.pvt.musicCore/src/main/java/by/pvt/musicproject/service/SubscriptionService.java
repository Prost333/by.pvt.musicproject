package by.pvt.musicproject.service;

import by.pvt.musicproject.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    void add(Subscription subscription);

    Subscription findSubscriptionById(Long id);

    void deleteSubscription(Long id);

    List<Subscription> getAllSubscription();
}
