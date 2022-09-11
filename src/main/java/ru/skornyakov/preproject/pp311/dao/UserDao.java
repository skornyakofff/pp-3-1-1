package ru.skornyakov.preproject.pp311.dao;

import ru.skornyakov.preproject.pp311.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserById(int id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUserById(int id);
}
