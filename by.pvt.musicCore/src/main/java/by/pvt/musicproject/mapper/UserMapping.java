package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.User;

public class UserMapping {
    public UserResponse toResponse(User user){
        UserResponse userResponse=new UserResponse();
        userResponse.setId(userResponse.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setLogin(userResponse.getLogin());
        userResponse.setPassword(userResponse.getPassword());

        userResponse.setRole(user.getRole());
        return userResponse;
    }

    public User toUserEntity(UserRequest userRequest){
        User user=new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());

        user.setRole(userRequest.getRole());
        return user;
    }


}
