package com.example.userorg.servics;

import com.example.userorg.model.User;

import java.util.List;

public interface UserServices {
    User addUser(User user);

    List<User> showUsers();

    User getUser(long id);

    User updateUser(long id, User user);

    void deleteUser(long id);
}
