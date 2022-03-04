package com.springmvc.services;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServicesImp implements UserServices{

    @Autowired(required = true)
    private UserDao userDao;

    public void doInsert(User user) {
        this.userDao.save(user);
    }
}
