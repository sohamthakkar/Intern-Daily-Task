package com.example.userorg.servicesImp;

import com.example.userorg.customException.ResourceNotFound;
import com.example.userorg.dao.UserDao;
import com.example.userorg.model.Orgenization;
import com.example.userorg.model.User;
import com.example.userorg.servics.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImp implements UserServices {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> showUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUser(long id) {
        Optional<User> listUser = userDao.findById(id);
        return listUser.orElseThrow(()-> new ResourceNotFound("User not found"));
    }

    @Override
    public User updateUser(long id, User user) {
        User user1 = userDao.findById(id).orElseThrow(() -> new ResourceNotFound("User Id: "+id+" is not found"));
        user.setUserId(id);
        return userDao.save(user);
    }

    @Override
    public void deleteUser(long id) {
        Optional<User> listUser = userDao.findById(id);
        if (listUser.isPresent()) {
            userDao.deleteById(id);
        }
        else {
            throw new ResourceNotFound("User not found");
        }
    }
}
