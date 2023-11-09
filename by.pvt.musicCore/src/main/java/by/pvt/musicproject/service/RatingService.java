package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.RatingReq;
import by.pvt.musicproject.dto.RatingRes;
import by.pvt.musicproject.entity.Rating;

import java.util.List;

public interface RatingService {
    RatingRes add (RatingReq ratingReq);

    RatingRes findRatingById(Long id);

    void deleteRating(Long id);

    List<RatingRes> getAllRating();
    RatingRes create(Long mark, Long trackId, Long userId);
    List<Rating> findByUserId(Long userId);
    List<Rating> findByTrackId(Long trackId);
    List<Rating> findByTrackIdAndUserid(Long trackId, Long userid);
}
