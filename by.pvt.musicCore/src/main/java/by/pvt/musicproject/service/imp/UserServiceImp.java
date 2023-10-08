package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.UserMapping;
import by.pvt.musicproject.repository.dao.DaoUser;
import by.pvt.musicproject.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {

    private final DaoUser dao;

    private UserMapping userMapping = new UserMapping();

    public UserServiceImp(DaoUser dao) {
        this.dao = dao;
    }

    public User addReq(UserRequest clientRequest) {
        User client = userMapping.toUserEntity(clientRequest);
        dao.add(client);
        return client;
    }

    public void add(User user) {
        dao.add(user);
    }

    public User findUserById(Long id) {
        return dao.findUserById(id);
    }

    public void deleteUser(Long id) {
        dao.deleteUser(id);
    }

    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    @Override
    public void addTrackToPlaylist(Long trackid, Long userId) {
        dao.addTrackToPlaylist(trackid, userId);
    }
}
