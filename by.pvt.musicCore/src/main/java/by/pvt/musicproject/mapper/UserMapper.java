package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target="password", ignore=true)
    @Mapping(target="id", ignore=true)
    UserResponse toResponse(User user);

    User toEntity(UserRequest userRequest);
}