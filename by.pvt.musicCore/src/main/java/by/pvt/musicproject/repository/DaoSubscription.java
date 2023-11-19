package by.pvt.musicproject.repository;

import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DaoSubscription extends JpaRepository<Subscription,Long> {
    List<Subscription> findByUser(User user);
    List<Subscription> findByStartData(LocalDateTime time);

}
