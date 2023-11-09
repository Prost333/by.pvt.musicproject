package by.pvt.musicproject.controller;

import by.pvt.musicproject.dto.RatingReq;
import by.pvt.musicproject.dto.RatingRes;
import by.pvt.musicproject.dto.TrackReq;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.mapper.RatingMapper;
import by.pvt.musicproject.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private RatingMapper ratingMapper;

    @PostMapping("/add")
    public RatingRes add(@RequestParam Long userId,@RequestParam Long trackId, @RequestParam Long mark) {
        return ratingService.create(mark,trackId,userId);

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

}
