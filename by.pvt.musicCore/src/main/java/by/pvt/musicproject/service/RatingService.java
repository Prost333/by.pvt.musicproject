package by.pvt.musicproject.service;

import by.pvt.musicproject.entity.Rating;

import java.util.List;

public interface RatingService {
    void add (Rating rating);

    Rating findRatingById(Long id);

    void deleteRating(Rating rating);

    List<Rating> getAllRating();
}
