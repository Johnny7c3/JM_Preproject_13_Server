package ru.javamentor.preproject.service;

import ru.javamentor.preproject.model.User;
import ru.javamentor.preproject.model.UserDto;

import java.util.List;

public interface UserService {
    
    List<UserDto> getUsers();
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(long id);
    User loadUserByUsername(String username);
}
