package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.repository.DaoSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImp {
    @Autowired
    public DaoSubscription daoSubscription;


    public void add(Subscription subscription) {
        daoSubscription.save(subscription);
    }

    public Subscription findSubscriptionById(Long id) {
        Optional<Subscription> track = Optional.of(daoSubscription.findById(id).orElseThrow());
        return track.get();
    }

    public void deleteSubscription(Subscription subscription) {
        daoSubscription.delete(subscription);
    }

    public List<Subscription> getAllSubscription() {
        return daoSubscription.findAll();
    }
}
