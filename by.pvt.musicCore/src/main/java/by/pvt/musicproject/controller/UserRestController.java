package by.pvt.musicproject.controller;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.UserMapper;
import by.pvt.musicproject.service.TrackListService;
import by.pvt.musicproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TrackListService trackListService;


    @GetMapping("/getAll")
    public List<UserResponse> findAllUsers() {
        return userService.getAllUserRes();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping
    public UserResponse addUser(@RequestBody @Validated UserRequest userRequest) {
        return userService.add(userRequest);
    }

    @GetMapping()
    public UserResponse getUserById(@RequestParam("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/file")
    public List<String> getTrackByUser(@RequestParam("id") Long id) {
        return userService.getAllTrackByUser(id);
    }
    @PostMapping("/create")
    public User createSubscriptionByUser(@RequestParam("userId") Long userId, @RequestParam("day") int day) {
        return userService.createSubscriptionByUser(userId, day);
    }
    @PostMapping("/addTrack")
    public String addTrackToUserPlaylist(@RequestParam("userId") Long userId,@RequestParam("trackId") Long trackId){
        Track track= trackListService.findTrackById(trackId);
        userService.addTrackToUser(userId,track);
        return "added "+track.getName()+" to library";
    }

    @PostMapping("/deleteTrack")
    public void deleteTrackByUser(@RequestParam("userId") Long userId,@RequestParam("trackId") Long trackId){
        userService.deleteTracks(userId,trackId);
    }

}
