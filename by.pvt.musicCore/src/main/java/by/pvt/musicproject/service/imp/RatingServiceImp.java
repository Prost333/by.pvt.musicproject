package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.repository.DaoRating;
import by.pvt.musicproject.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImp implements RatingService {
    @Autowired
    private DaoRating daoRating;

    public void add(Rating rating) {
         daoRating.save(rating);
    }


    public Rating findRatingById(Long id) {
        Optional<Rating> sale = Optional.of(daoRating.findById(id).orElseThrow());
        return sale.get();
    }


    public void deleteRating(Rating rating) {
        daoRating.delete(rating);
    }


    public List<Rating> getAllRating() {
        return daoRating.findAll();
    }
}
