package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.SubscriptionRes;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.SubscriptionMapper;
import by.pvt.musicproject.repository.DaoSubscription;
import by.pvt.musicproject.service.AmountService;
import by.pvt.musicproject.service.SubscriptionService;
import by.pvt.musicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImp implements SubscriptionService {

    public final DaoSubscription daoSubscription;

    public final SubscriptionMapper subscriptionMapper;
    public final AmountService amountService;


    public void add(Subscription subscription) {
        daoSubscription.save(subscription);
    }

    public Subscription findSubscriptionById(Long id) {
        Optional<Subscription> track = Optional.of(daoSubscription.findById(id).orElseThrow());
        return track.get();
    }

    @Override
    public void deleteSubscriptionById(Long id) {
        daoSubscription.deleteById(id);
    }

    public void deleteSubscription(Subscription subscription) {
        daoSubscription.delete(subscription);
    }

    public List<Subscription> getAllSubscription() {
        return daoSubscription.findAll();
    }

    public void calculateTimeDifference(LocalDateTime end) {
        LocalDateTime now = LocalDateTime.now();

        if (end.isAfter(now)) {
            Duration duration = Duration.between(now, end);
            long hoursDifference = duration.toHours();

            System.out.println("Разница во времени: " + hoursDifference + " часов.");
        } else {
            System.out.println("Указанное время меньше или равно текущему времени.");
        }
    }

    public Subscription defaultSubscription(User user) {
        String date = "1998-01-16 13:18";
        LocalDateTime time = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Subscription subscription = new Subscription();
        subscription.setStartData(now());
        subscription.setEndData(time);
        subscription.setUser(user);
        subscription.setUserId(user.getId());
        daoSubscription.save(subscription);
        return subscription;
    }

    public Subscription subByProducer(Producer producer){
        Subscription subscription=defaultSubscription(producer);
        subscription.setEndData(LocalDateTime.now().plus(2,ChronoUnit.YEARS));
        subscription.setSubsPrice(BigDecimal.valueOf(amountService.findAll().get(0).getAmountByProducer()));
        subscription.setUserId(producer.getId());
        producer.setSubscription(subscription);
        daoSubscription.save(subscription);
        return subscription;
    }



}
