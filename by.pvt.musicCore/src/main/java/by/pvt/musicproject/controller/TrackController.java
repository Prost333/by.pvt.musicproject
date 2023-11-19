package by.pvt.musicproject.controller;

import by.pvt.musicproject.aop.verification.ControlSessionUserBySubscription;
import by.pvt.musicproject.dto.*;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.mapper.TrackMapper;
import by.pvt.musicproject.music.AdapterSend;
import by.pvt.musicproject.music.RecordPlayer;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.PerformerService;
import by.pvt.musicproject.service.TrackListService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("track")
@RequiredArgsConstructor
public class TrackController {

    private final TrackListService trackListService;
    private final TrackMapper trackMapper;

    private final AlbumService albumService;

    private final PerformerService performerService;
    private final RecordPlayer recordPlayer;
    private  final AdapterSend adapterSend;

    @PostMapping("/add")
    public TrackRes add(@RequestBody TrackReq trackReq) {
        return adapterSend.addTrack(trackReq);
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
        Album album1 = albumService.findEntityByName(album).get(0);
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
        return tracks.map(trackMapper::toResponse);
    }

    @SneakyThrows
    @ControlSessionUserBySubscription
    @GetMapping("/start")
    public TrackRes start(@RequestParam Long trackId) {
        recordPlayer.playList(Collections.singletonList(trackListService.findTrackById(trackId).getFile()));
        return trackListService.findTrackByIdRes(trackId);
    }

    @GetMapping("/userList")
    @ControlSessionUserBySubscription
    public List<TrackRes> playUserList(@RequestParam Long id) {
        return trackListService.playTrackByUserPlaylist(id);
    }


    @PostMapping("/startByPerformerName")
    @ControlSessionUserBySubscription
    public List<TrackRes> startByPerformerName(@RequestBody PerformersReq performersReq) {
        trackListService.findTracksByPerformerName(performersReq.getName());
        return trackListService.findByPerformer(performerService.findPerformerEntityByName(performersReq.getName()).get(0));
    }

    @GetMapping("/stop")
    public String stop() {
        recordPlayer.stop();
        return "stop track";
    }

    @GetMapping("/pause")
    public void pause() {
        recordPlayer.pause();
    }

    @GetMapping("/next")
    public void next() {
        recordPlayer.next();
    }


}
