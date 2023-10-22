package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.dao.DaoUser;
import by.pvt.musicproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp  {
    @Autowired
    private DaoUser dao;

    public void add(User user) {
        dao.save(user);
    }

    public User findUserById(Long id) {
        Optional<User> user = Optional.of(dao.findById(id).orElseThrow());
        return user.get();
    }

    public void deleteUser(User user) {
        dao.delete(user);
    }

    public List<User> getAllUser() {
        return dao.findAll();
    }

    public User addTrackToUser(Long userId, Track track) {
        User user = dao.findById(userId).orElse(null);
        if (user != null) {
            user.getTrack().add(track);
            return dao.save(user);
        } else {

            return null;
        }}
}
