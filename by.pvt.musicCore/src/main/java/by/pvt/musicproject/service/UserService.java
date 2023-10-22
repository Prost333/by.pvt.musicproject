package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User findUserById(Long id);
    void deleteUser(User user);
    List<User> getAllUser();
    void addTrackToPlaylist(Long trackid, Long userId);
}
