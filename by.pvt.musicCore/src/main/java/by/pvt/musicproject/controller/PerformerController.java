package by.pvt.musicproject.controller;

import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.dto.PerformersRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.mapper.PerformerMapper;
import by.pvt.musicproject.repository.DaoPerformer;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("performer")
public class PerformerController {
    @Autowired
    private PerformerService performerService;
    @Autowired
    private PerformerMapper performerMapper;
    @Autowired
    private AlbumService albumService;


    @GetMapping("/getAll")
    public List<PerformersRes> findAllPerformer() {
        return performerService.getAllPerformer();
    }

    @GetMapping()
    public PerformersRes getById(@RequestParam("id") Long id) {
        return performerService.findPerformerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        performerService.deletePerformer(id);
    }

    @PostMapping("/add")
    public PerformersRes addPerformer(@RequestBody PerformersReq performersReq) {
        return performerService.add(performersReq);
    }

    @PostMapping("/addAlbum")
    public String addAlbumToPerformer(@RequestParam("AlbumId") Long albumId, @RequestParam("PerformerId") Long performerId) {
        Album album = albumService.findEntityById(albumId);
        performerService.addAlbumToPerformer(performerId, album);
        return "added " + album.getName() + " to performer";
    }

    @GetMapping("/page")
    public Page<PerformersRes> getPerformers(@RequestParam int page, @RequestParam int size) {
        Page<Performer> performers = performerService.getAllPerformerPage(page,size);
        return performers.map(performer -> performerMapper.toResponse(performer));
    }
    @GetMapping("/name")
    public List<PerformersRes> findPerformerByName(@RequestParam String name){
        return performerService.findPerformerByName(name);
    }

}
