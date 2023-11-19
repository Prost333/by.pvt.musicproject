package by.pvt.musicproject.repository;

import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DaoTrackList extends JpaRepository<Track,Long>  {

    List<Track> findByStyle(String style);
    List<Track> findByPerformer(Performer performer);
    List<Track> findByAlbums(Album album);
    List<Track> findByName(String name);
    @Query("SELECT t.file FROM Track t WHERE t.performer.id = :performer_id")
    List<String> findFileByPerformerId(@Param("performer_id")Long performerId);

    @Query("SELECT t.file FROM Track t WHERE t.performer.name = ?1")
    List<String> findTracksByPerformerName(String performerName);

}
