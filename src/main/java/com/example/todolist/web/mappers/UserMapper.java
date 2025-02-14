package com.example.todolist.web.mappers;

import com.example.todolist.domain.user.User;
import com.example.todolist.web.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "confirmPassword", target = "confirmPassword")
    @Mapping(source = "id", target = "id")
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}

