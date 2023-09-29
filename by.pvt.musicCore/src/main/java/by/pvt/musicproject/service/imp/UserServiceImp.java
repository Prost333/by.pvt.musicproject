package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.entity.MyPlayList;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.PlayListMapping;
import by.pvt.musicproject.mapper.UserMapping;
import by.pvt.musicproject.repository.MyPlayListRepository;
import by.pvt.musicproject.repository.dao.DaoUser;
import by.pvt.musicproject.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {

    private final DaoUser dao;
    private PlayListMapping playListMapping = new PlayListMapping();
    private MyPlayListRepository myPlayListRepository = new MyPlayListRepository();
    private UserMapping userMapping;

    public UserServiceImp(DaoUser dao) {
        this.dao = dao;
    }

    public void addUser(UserRequest userRequest) {
        Long playlistid = null;
        MyPlayList myPlayList = myPlayListRepository.findPlayListById(userRequest.getId());
        User user = userMapping.toUserEntity(userRequest);
        playlistid=myPlayListRepository.add(myPlayList);


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
}
