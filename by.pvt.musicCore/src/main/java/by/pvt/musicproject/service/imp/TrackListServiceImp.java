package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.aop.verification.CheckSubscription;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.dto.TrackReq;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.TrackMapper;
import by.pvt.musicproject.mapper.UserMapper;
import by.pvt.musicproject.music.RecordPlayer;
import by.pvt.musicproject.repository.DaoTrackList;
import by.pvt.musicproject.repository.DaoUser;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.TrackListService;
import by.pvt.musicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackListServiceImp implements TrackListService {

    private final DaoTrackList dao;
    private final UserService userService;
    private final UserMapper userMapper;
    private final TrackMapper trackMapper;
    private final RecordPlayer recordPlayer;
    private final DaoUser daoUser;

    @SneakyThrows
    public TrackRes add(Track track) {
        Track track1 = dao.save(track);
        return trackMapper.toResponse(track1);
    }

    @CheckSubscription
    public Map<UserResponse, List<TrackRes>> addTrackToUser(Long userId, Long trackId) {
        Map<UserResponse, List<TrackRes>> map = new HashMap<>();
        Track track = findTrackById(trackId);
        User user = userService.findEntitybyId(userId);
        if (user != null && !user.getTrack().contains(track)) {
            user.getTrack().add(track);
            daoUser.save(user);
        }
        List<TrackRes> trackRes = user.getTrack().stream().map(trackMapper::toResponse).collect(Collectors.toList());
        UserResponse userResponse =userMapper.toResponse(user);
        map.put(userResponse,trackRes);
        return map;
    }

    @Override
    public Track addEntity(Track track) {
        return dao.save(track);
    }

    public TrackRes findTrackByIdRes(Long id) {
        return trackMapper.toResponse(findTrackById(id));
    }


    public Track findTrackById(Long id) {
        Optional<Track> track = Optional.of(dao.findById(id).orElseThrow());
        return track.get();
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public List<TrackRes> getAllList() {
        return dao.findAll().stream().map(trackMapper::toResponse).collect(Collectors.toList());
    }

    public List<TrackRes> findByStyle(String style) {
        return dao.findByStyle(style).stream().map(trackMapper::toResponse).collect(Collectors.toList());
    }

    public List<TrackRes> findByPerformer(Performer performer) {
        return dao.findByPerformer(performer).stream().map(trackMapper::toResponse).collect(Collectors.toList());
    }

    public List<TrackRes> findByAlbums(Album album) {
        recordPlayer.playList(dao.findByAlbums(album).stream().map(Track::getFile).collect(Collectors.toList()));
        return dao.findByAlbums(album).stream().map(trackMapper::toResponse).collect(Collectors.toList());
    }

    public List<TrackRes> findByName(String name) {
        return dao.findByName(name).stream().map(trackMapper::toResponse).collect(Collectors.toList());
    }

    public List<String> findAllByFile() {
        List<Track> tracks = dao.findAll();
        return tracks.stream()
                .map(Track::getFile)
                .toList();
    }

    public Page<Track> getAllTrackPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return dao.findAll(pageable);
    }

    public List<String> findFileByPerformerId(Long id) {
        return dao.findFileByPerformerId(id);
    }

    public List<String> findTracksByPerformerName(String performerName) {
        recordPlayer.playList(dao.findTracksByPerformerName(performerName));
        return dao.findTracksByPerformerName(performerName);
    }

    public List<TrackRes> playTrackByUserPlaylist(Long userId) {
        List<Track> tracks = userService.findEntitybyId(userId).getTrack();
        recordPlayer.playList(tracks.stream().map(Track::getFile).collect(Collectors.toList()));
        return tracks.stream().map(trackMapper::toResponse).collect(Collectors.toList());
    }


}
