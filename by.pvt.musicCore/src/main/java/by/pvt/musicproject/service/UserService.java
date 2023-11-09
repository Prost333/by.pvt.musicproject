package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse add(UserRequest userRequest);

    UserResponse findUserById(Long id);

    void deleteUser(Long id);

    List<User> getAllUser();

    void addTrackToUser(Long userId, Track track);

    User createSubscriptionByUser(Long userId, int day);
    List<String> getAllTrackByUser(Long id);
    void deleteTracks(Long userId, Long trackId);
    List<UserResponse> getAllUserRes();
    User findEntitybyId(Long id);

}
