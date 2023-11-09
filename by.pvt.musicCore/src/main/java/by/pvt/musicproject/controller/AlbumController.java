package by.pvt.musicproject.controller;

import by.pvt.musicproject.dto.AlbumsReq;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.mapper.AlbumMapper;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.TrackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private TrackListService trackListService;

    @PostMapping("/add")
    public AlbumsRes add(@RequestBody AlbumsReq albumReq) {
        return albumService.add(albumReq);
    }

    @GetMapping("/getAll")
    public List<AlbumsRes> findAllPerformer() {
        return albumService.getAllAlbum();
    }

    @GetMapping()
    public AlbumsRes getById(@RequestParam("id") Long id) {
        return albumService.findAlbumById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        albumService.deleteAlbum(id);
    }
    @PostMapping("/addTrack")
    public String addAlbumToPerformer(@RequestParam("trackId") Long trackId, @RequestParam("albumId") Long albumId) {
        Track track=trackListService.findTrackById(trackId);
       albumService.addTrackToAlbum(albumId,track);
        return "added " + track.getName() + " to album";
    }

    @GetMapping("/name")
    public List<AlbumsRes> findByName(@RequestParam String name){
        return albumService.findByName(name).stream().map(album -> albumMapper.toResponse(album)).collect(Collectors.toList());
    }
    @GetMapping("/page")
    public Page<AlbumsRes> getPerformers(@RequestParam int page, @RequestParam int size) {
        Page<Album> albums = albumService.getAllAlbumPage(page,size);
        return albums.map(album -> albumMapper.toResponse(album));
    }

}
