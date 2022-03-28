package com.example.springsecurityclient.services;

import com.example.springsecurityclient.customexception.ResourceNotFound;
import com.example.springsecurityclient.dao.UserDao;
import com.example.springsecurityclient.dao.VerificationUserRepository;
import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.entity.VerificationToken;
import com.example.springsecurityclient.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImp implements  UserServices{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDao userDao;

    @Autowired
    VerificationUserRepository verificationUserRepository;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstname(userModel.getFirstname());
        user.setLastname(userModel.getLastname());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        System.out.println(user);
        userDao.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationUserRepository.save(verificationToken);
    }
}
