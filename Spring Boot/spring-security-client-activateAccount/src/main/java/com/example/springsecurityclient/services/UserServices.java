package com.example.springsecurityclient.services;

import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.model.UserModel;

import java.util.List;

public interface UserServices {

    User registerUser(UserModel userModel);
    void saveVerificationTokenForUser(String token, User user);
}
