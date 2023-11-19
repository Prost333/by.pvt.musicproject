package by.pvt.musicproject.repository;

import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.Track;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DaoRating extends JpaRepository<Rating, Long> {
    List<Rating> findByUserid(Long userId);

    List<Rating> findByTrackId(Long trackId);

    List<Rating> findByTrackIdAndUserid(Long trackId, Long userId);

    @Query("SELECT r.trackId, AVG(r.mark) AS average_mark " +
            "FROM Rating r " +
            "GROUP BY r.trackId " +
            "ORDER BY average_mark DESC")
    List<Object[]> findTrackWithHighestAverageMark();

    @Query("SELECT t.name, AVG(r.mark) AS average_mark, COUNT(r) AS count " +
            "FROM Track t JOIN t.ratings r " +
            "GROUP BY t.name " +
            "ORDER BY average_mark DESC")
    List<Object[]> findTrackWithHighestAverageMark(Pageable pageable);

    @Query("SELECT a.name, t.name, COUNT(r) as count " +
            "FROM Album a JOIN a.track t JOIN t.ratings r " +
            "GROUP BY a.name, t.name " +
            "ORDER BY count DESC")
    List<Object[]> findAlbumWithTrackHavingMostRatings(Pageable pageable);

    @Query("SELECT t.name, COUNT(r) as count, AVG(r.mark) as average_mark " +
            "FROM Track t JOIN t.ratings r " +
            "GROUP BY t.name " +
            "ORDER BY count DESC , AVG(r.mark)")
    List<Object[]> findTrackWithRatingCountAndAverageMark();

}

