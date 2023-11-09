package by.pvt.musicproject.controller;

import by.pvt.musicproject.dto.*;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.mapper.TrackMapper;
import by.pvt.musicproject.music.RecordPlayer;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.PerformerService;
import by.pvt.musicproject.service.TrackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("track")
public class TrackController {
    @Autowired
    private TrackListService trackListService;
    @Autowired
    private TrackMapper trackMapper;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private PerformerService performerService;
    private RecordPlayer recordPlayer = new RecordPlayer();

    @PostMapping("/add")
    public TrackRes add(@RequestBody TrackReq trackReq) {
        return trackListService.add(trackReq);
    }

    @GetMapping("/getAll")
    public List<TrackRes> findAllPerformer() {
        return trackListService.getAllList();
    }

    @GetMapping()
    public TrackRes getById(@RequestParam("id") Long id) {
        return trackListService.findTrackByIdRes(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trackListService.delete(id);
    }

    @GetMapping("/name")
    public List<TrackRes> findByName(@RequestParam String name) {
        return trackListService.findByName(name);
    }

    @GetMapping("/style")
    public List<TrackRes> findByStyle(@RequestParam String style) {
        return trackListService.findByStyle(style);
    }

    @GetMapping("/album")
    public List<TrackRes> findByAlbum(@RequestParam String album) {
        Album album1 = albumService.findByName(album).get(0);
        return trackListService.findByAlbums(album1);
    }

    @GetMapping("/performer")
    public List<TrackRes> findByPerformer(@RequestParam String performer) {
        Performer performer1 = performerService.findPerformerEntityByName(performer).get(0);
        return trackListService.findByPerformer(performer1);
    }

    @GetMapping("/allFile")
    public List<String> getAllFile() {
        return trackListService.findAllByFile();
    }

    @GetMapping("/page")
    public Page<TrackRes> getTracks(@RequestParam int page, @RequestParam int size) {
        Page<Track> tracks = trackListService.getAllTrackPage(page, size);
        return tracks.map(track -> trackMapper.toResponse(track));
    }

    @GetMapping("/start")
    public void start(@RequestParam Long trackId) {
        recordPlayer.playlist(Collections.singletonList(trackListService.findTrackById(trackId).getFile()));
    }
    @GetMapping ("/stop")
    public String stop() {
       recordPlayer.stopPlaying();
       return "stop track";
    }


}
