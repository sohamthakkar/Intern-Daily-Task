package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.dao.UserDao;
import com.example.SpringBootDemo.model.UserModel;
import com.example.SpringBootDemo.services.UserServices;
import com.example.SpringBootDemo.services.UserServicesImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @MockBean
    private UserServices userServices;

    @InjectMocks
    private UserController userController;

    @Test
    @Order(1)
    @Rollback(value = false)
    void saveEmployee() {
        UserModel user= new UserModel("test","test","test@g.c", "1234567890");
        userController.saveEmployee(user);
        Assertions.assertThat(user).isNotNull();
    }

    @Test
    void showUser() {
        UserModel user= new UserModel("test","test","test@g.c", "123456789");

    }

    @Test
    void singleUser() {
    }

    @Test
    void updateData() {
    }

    @Test
    void deleteUser() {
    }
}