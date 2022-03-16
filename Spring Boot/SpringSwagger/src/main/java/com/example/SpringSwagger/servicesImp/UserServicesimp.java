package com.example.SpringSwagger.servicesImp;

import com.example.SpringSwagger.dao.UserDao;
import com.example.SpringSwagger.model.User;
import com.example.SpringSwagger.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesimp implements UserServices {
    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> displayUser() {
        return userDao.findAll();
    }
}
