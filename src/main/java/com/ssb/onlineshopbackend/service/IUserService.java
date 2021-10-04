package com.ssb.onlineshopbackend.service;

import com.ssb.onlineshopbackend.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(User user);
    User getUserByEmail(String email);
    User getUserById(Long id);
    void deleteUser(Long id);

}
