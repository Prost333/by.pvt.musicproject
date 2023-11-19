package rating;
import by.pvt.musicproject.dto.RatingRes;
import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.mapper.RatingMapper;
import by.pvt.musicproject.repository.DaoRating;
import by.pvt.musicproject.service.TrackListService;
import by.pvt.musicproject.service.UserService;
import by.pvt.musicproject.service.imp.RatingServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith({MockitoExtension.class})
public class RatingServiceImpTest {

    @InjectMocks
    private RatingServiceImp ratingServiceImp;

    @Mock
    private DaoRating daoRating;

    @Mock
    private RatingMapper ratingMapper;

    @Mock
    private UserService userService;

    @Mock
    private TrackListService trackListService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreate() {
        Long mark = 5L;
        Long trackId = 1L;
        Long userId = 1L;

        when(daoRating.findByTrackIdAndUserid(trackId, userId)).thenReturn(Collections.emptyList());

        Rating rating = new Rating();
        rating.setMark(mark);
        rating.setUserid(userId);
        rating.setTrackId(trackId);

        when(trackListService.findTrackById(trackId)).thenReturn(new Track());
        when(daoRating.save(any(Rating.class))).thenReturn(rating);
        when(ratingMapper.toResponse(any(Rating.class))).thenReturn(new RatingRes());

        ratingServiceImp.create(mark, trackId, userId);

        verify(daoRating, times(1)).findByTrackIdAndUserid(trackId, userId);
        verify(daoRating, times(1)).save(any(Rating.class));
        verify(ratingMapper, times(1)).toResponse(any(Rating.class));
    }
}