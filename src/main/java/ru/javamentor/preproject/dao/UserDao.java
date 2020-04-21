package ru.javamentor.preproject.dao;

import ru.javamentor.preproject.model.User;
import ru.javamentor.preproject.model.UserDto;

import java.util.List;

public interface UserDao {
    
    List<UserDto> getUsers();
    boolean createUser(User user);
    boolean updateUser(User user);
    void deleteUser(long id);
    User loadUserByUsername(String username);
}
