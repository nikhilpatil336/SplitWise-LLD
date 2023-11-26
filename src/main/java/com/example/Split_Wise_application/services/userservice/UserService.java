package com.example.Split_Wise_application.services.userservice;

import com.example.Split_Wise_application.models.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    User updateUser(User user, int id);

    void deleteUser(int id);
}
