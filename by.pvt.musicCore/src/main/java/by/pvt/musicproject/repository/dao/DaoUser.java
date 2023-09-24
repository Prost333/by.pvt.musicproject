package by.pvt.musicproject.repository.dao;

import by.pvt.musicproject.entity.User;

import java.util.List;

public interface DaoUser {
    void add(User user);

    User findUserById(Long id);

    void deleteUser(Long id);

    List<User> getAllUser();
}

