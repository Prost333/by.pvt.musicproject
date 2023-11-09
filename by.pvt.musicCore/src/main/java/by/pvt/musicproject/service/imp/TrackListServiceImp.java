package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.TrackReq;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.mapper.TrackMapper;
import by.pvt.musicproject.repository.DaoTrackList;
import by.pvt.musicproject.service.TrackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrackListServiceImp implements TrackListService {
    @Autowired
    private DaoTrackList dao;
    @Autowired
    private TrackMapper trackMapper;

    public TrackRes add(TrackReq track) {
        Track track1 = dao.save(trackMapper.toEntity(track));
        return trackMapper.toResponse(track1);
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
        return dao.findAll().stream().map(track -> trackMapper.toResponse(track)).collect(Collectors.toList());
    }

    public List<TrackRes> findByStyle(String style) {
        return dao.findByStyle(style).stream().map(track -> trackMapper.toResponse(track)).collect(Collectors.toList());
    }

    public List<TrackRes> findByPerformer(Performer performer) {
        return dao.findByPerformer(performer).stream().map(track -> trackMapper.toResponse(track)).collect(Collectors.toList());
    }

    public List<TrackRes> findByAlbums(Album album) {
        return dao.findByAlbums(album).stream().map(track -> trackMapper.toResponse(track)).collect(Collectors.toList());
    }

    public List<TrackRes> findByName(String name) {
        return dao.findByName(name).stream().map(track -> trackMapper.toResponse(track)).collect(Collectors.toList());
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


}
