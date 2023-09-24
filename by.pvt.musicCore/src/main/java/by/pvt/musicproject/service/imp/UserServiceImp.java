package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.UserMapping;
import by.pvt.musicproject.repository.dao.DaoUser;
import by.pvt.musicproject.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {

    private  final DaoUser dao;
    private UserMapping userMapping;

    public UserServiceImp(DaoUser dao) {
        this.dao = dao;
    }

    public void add(User user){
        dao.add(user);
    }
    public User findUserById(Long id){
        return dao.findUserById(id);
    }
    public void deleteUser(Long id){
        dao.deleteUser(id);
    }
    public List<User> getAllUser(){
        return  dao.getAllUser();
    }
}
