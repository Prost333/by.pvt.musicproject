package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.SubscriptionRes;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import jakarta.servlet.ServletException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse add(UserRequest userRequest) throws Exception;

    UserResponse findUserById(Long id);

    void deleteUser(Long id);

    List<User> getAllUser();

    SubscriptionRes createSubscriptionByUser(Long userId, int day);
    List<TrackRes> getAllTrackByUser(Long id);
    void deleteTracks(Long userId, Long trackId);
    List<UserResponse> getAllUserRes();
    User findEntitybyId(Long id);
    UserDetails loadUserByUsername(String username);
    UserResponse login (UserRequest userRequest) throws ServletException;
    void logout() throws ServletException;
}
