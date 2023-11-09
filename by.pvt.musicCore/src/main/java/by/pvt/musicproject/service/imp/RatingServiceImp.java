package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.RatingReq;
import by.pvt.musicproject.dto.RatingRes;
import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.mapper.RatingMapper;
import by.pvt.musicproject.repository.DaoRating;
import by.pvt.musicproject.service.RatingService;
import by.pvt.musicproject.service.TrackListService;
import by.pvt.musicproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

@Service
public class RatingServiceImp implements RatingService {
    @Autowired
    private DaoRating daoRating;
    @Autowired
    private RatingMapper ratingMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private TrackListService trackListService;

    public RatingRes create(Long mark, Long trackId, Long userId) {
        if (findByTrackIdAndUserid(trackId, userId).isEmpty()) {
            Rating rating = new Rating();
            rating.setMark(mark);
            rating.setUserid(userId);
            rating.setTrackId(trackId);
            daoRating.save(rating);
            return ratingMapper.toResponse(rating);
        }else{
            Rating rating =findByTrackIdAndUserid(trackId, userId).get(0);
            rating.setMark(mark);
            daoRating.save(rating);
            return ratingMapper.toResponse(rating);
        }
    }

    @Override
    public List<Rating> findByUserId(Long userId) {
        return daoRating.findByUserid(userId);
    }

    @Override
    public List<Rating> findByTrackId(Long trackId) {
        return daoRating.findByTrackId(trackId);
    }

    @Override
    public List<Rating> findByTrackIdAndUserid(Long trackId, Long userId) {
        return daoRating.findByTrackIdAndUserid(trackId, userId);
    }


    public RatingRes add(RatingReq ratingReq) {
        Rating rating = ratingMapper.toEntity(ratingReq);
        daoRating.save(rating);
        return ratingMapper.toResponse(rating);
    }


    public RatingRes findRatingById(Long id) {
        Optional<Rating> sale = Optional.of(daoRating.findById(id).orElseThrow());
        return ratingMapper.toResponse(sale.get());
    }


    public void deleteRating(Long id) {
        daoRating.deleteById(id);
    }


    public List<RatingRes> getAllRating() {
        return daoRating.findAll().stream().map(rating -> ratingMapper.toResponse(rating)).collect(Collectors.toList());
    }
}
