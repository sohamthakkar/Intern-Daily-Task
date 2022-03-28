package com.example.SpringSwagger.services;

import com.example.SpringSwagger.model.User;

import java.util.List;

public interface UserServices {

    void saveUser(User user);

    List<User> displayUser();
}
