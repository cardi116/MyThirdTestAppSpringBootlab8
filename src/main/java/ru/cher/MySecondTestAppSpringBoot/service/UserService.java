package ru.cher.MySecondTestAppSpringBoot.service;

import ru.cher.MySecondTestAppSpringBoot.dto.UserDto;
import ru.cher.MySecondTestAppSpringBoot.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}