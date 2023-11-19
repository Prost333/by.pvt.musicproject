package by.pvt.musicproject.controller;

import by.pvt.musicproject.aop.verification.ControlSessionUserBySubscription;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.UserMapper;
import by.pvt.musicproject.service.TrackListService;
import by.pvt.musicproject.service.UserService;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    private final UserMapper userMapper;

    private final TrackListService trackListService;

    private Authentication authentication;

    @GetMapping("/getAll")
    public List<UserResponse> findAllUsers() {
        return userService.getAllUserRes();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/addUser")
    public UserResponse addUser(@RequestBody @Validated UserRequest userRequest) throws Exception {
        return userService.add(userRequest);
    }

    @GetMapping()
    public UserResponse getUserById(@RequestParam("id") Long id) {
        return userService.findUserById(id);
    }


    @GetMapping("/file")
    public List<TrackRes> getTrackByUser() {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return userService.getAllTrackByUser(user.getId());
    }

    @GetMapping("/create")
    public UserResponse createSubscriptionByUser(@RequestParam("userId") Long userId, @RequestParam("day") int day) {
        return userService.createSubscriptionByUser(userId, day);
    }


    @GetMapping("/addTrack")
    @ControlSessionUserBySubscription
    public String addTrackToUserPlaylist(@RequestParam("trackId") Long trackId) {
        Track track = trackListService.findTrackById(trackId);
        User user=(User) authentication.getPrincipal();
        userService.addTrackToUser(user.getId(), track);
        return "added " + track.getName() + " to library";
    }

    @PostMapping("/deleteTrack")
    public void deleteTrackByUser(@RequestParam("userId") Long userId, @RequestParam("trackId") Long trackId) {
        userService.deleteTracks(userId, trackId);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserResponse login(@RequestBody UserRequest userRequest) throws ServletException {
        return userService.login(userRequest);
    }

    @GetMapping("/logout")
    public void logout() throws ServletException {
        userService.logout();
    }

}
