package by.pvt.musicproject.controller;

import by.pvt.musicproject.dto.RatingReq;
import by.pvt.musicproject.dto.RatingRes;
import by.pvt.musicproject.dto.TrackReq;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.RatingMapper;
import by.pvt.musicproject.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;
    private Authentication authentication;

    @PostMapping("/add")
    public RatingRes add(@RequestBody RatingReq ratingReq) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return ratingService.create(ratingReq.getMark(), ratingReq.getTrackId(), user.getId());
    }

    @GetMapping("/getAll")
    public List<RatingRes> findAllPerformer() {
        return ratingService.getAllRating();
    }

    @GetMapping()
    public RatingRes getById(@RequestParam("id") Long id) {
        return ratingService.findRatingById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
       ratingService.deleteRating(id);
    }

    @GetMapping("/top5")
    public List<Object[]> top5(){
        return ratingService.findTrackWithHighestAverageMark(PageRequest.of(0, 5));
    }

    @GetMapping("/topAlbum")
    public List<Object[]> topAlbum(){
        return ratingService.findAlbumWithTrackHavingMostRatings(PageRequest.of(0,5));
    }
    @GetMapping("/mostPopularTrack")
    public List<Object[]> findTrackWithRatingCountAndAverageMark() {
        return ratingService.findTrackWithRatingCountAndAverageMark();
    }
    @GetMapping("/allListRating")
    public List<Object[]> getAllList(){
        return ratingService.findTrackWithHighestAverageMark();
    }

}
