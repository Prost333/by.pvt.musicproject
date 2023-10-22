package by.pvt.musicproject.repository;

import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaoRating extends JpaRepository<Rating,Long> {

}
