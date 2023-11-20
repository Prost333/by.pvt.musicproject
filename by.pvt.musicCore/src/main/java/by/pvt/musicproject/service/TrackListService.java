package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.TrackReq;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TrackListService {
    TrackRes add(Track track);

    Track addEntity(Track track);

    Track findTrackById(Long id);

    void delete(Long id);

    List<TrackRes> getAllList();

    List<TrackRes> findByStyle(String style);

    List<TrackRes> findByPerformer(Performer performer);

    List<TrackRes> findByAlbums(Album album);

    List<TrackRes> findByName(String name);

    Map<UserResponse, List<TrackRes>> addTrackToUser(Long userId, Long trackId);

    List<String> findAllByFile();

    TrackRes findTrackByIdRes(Long id);

    Page<Track> getAllTrackPage(int page, int size);

    List<String> findFileByPerformerId(Long id);

    List<String> findTracksByPerformerName(String performerName);

    List<TrackRes> playTrackByUserPlaylist(Long userId);


}
