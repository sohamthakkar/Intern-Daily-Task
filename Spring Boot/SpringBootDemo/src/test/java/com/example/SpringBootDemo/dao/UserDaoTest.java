package com.example.SpringBootDemo.dao;

import com.example.SpringBootDemo.model.UserModel;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest(){
        UserModel user = new UserModel();
        user.setFname("test");
        user.setLname("test");
        user.setEmail("test@gmail.com");
        user.setMobile("3265417890");

        userDao.save(user);
        Assertions.assertThat(user.getId()).isNotNull();
    }

    @Test
    @Order(2)
    public void findAllUserTest(){
        List<UserModel>user = userDao.findAll();
        Assertions.assertThat(user).isNotEmpty();
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void findUserByIdTest(){

        Optional<UserModel> user = userDao.findById(2);

        Assertions.assertThat(user.get().getFname()).isEqualTo("nisarg");
    }

    @Test
    @Order(4)
    public void updateUserTest(){
        UserModel user = userDao.findById(11).get();
        user.setFname("testing");
        Assertions.assertThat(user.getFname()).isEqualTo("testing");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        UserModel userModel = userDao.findById(14).get();
        userDao.delete(userModel);

        UserModel userModel1 = null;

        Optional<UserModel> userData = userDao.findById(14);
        if(userData.isPresent()){
            userModel1 = userData.get();
        }
        Assertions.assertThat(userModel1).isNull();
    }

}