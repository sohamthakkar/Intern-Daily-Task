package com.example.services;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServicesImp implements UserServices {

    @Autowired
    private UserDao userDao;

    @Override
    public void insert(User user) {
        this.userDao.save(user);
    }
}
