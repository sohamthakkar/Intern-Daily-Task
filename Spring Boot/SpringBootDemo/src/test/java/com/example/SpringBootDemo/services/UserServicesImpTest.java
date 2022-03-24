package com.example.SpringBootDemo.services;

import com.example.SpringBootDemo.dao.UserDao;
import com.example.SpringBootDemo.model.UserModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
class UserServicesImpTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServicesImp userServices;

    @Test
    @Order(1)
    @Rollback(value = false)
    void saveEmployee() {
        UserModel user= new UserModel("test","test","test@g.c", "123456789");
        userServices.saveEmployee(user);
        Assertions.assertThat(user).isNotNull();

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    void userList() {
        List<UserModel> userModelList = new ArrayList<>();
        UserModel userone= new UserModel("test","test","test@g.c", "123456789");
        UserModel userteo= new UserModel("test1","test1","test1@g.c", "1346798520");
        UserModel userthree= new UserModel("test2","test2","test2@g.c", "1379864250");

        userModelList.add(userone);
        userModelList.add(userteo);
        userModelList.add(userthree);

        when(userDao.findAll()).thenReturn(userModelList);

        //test
        List<UserModel> userList = userServices.userList();

        assertEquals(3, userList.size());

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    void userData() {
        //1. using when
        when(userDao.findById(1)).thenReturn(Optional.of(new UserModel(1, "test", "test", "test@gmail.com", "1234569870")));

        UserModel user = userServices.userData(1);
        assertEquals("test", user.getFname());

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    void updateUser() {
        //Mocking
       UserModel user = new UserModel();
        user.setId(1);
        user.setFname("test");
        user.setLname("test");
        user.setEmail("test@g.c");
        user.setMobile("123456789");

        //Mocking
        when(userDao.findById(1)).thenReturn(Optional.of(user));

        //test
        UserModel updatedData = userServices.updateUser(user,1);

        //mocking
        when(userDao.save(updatedData)).thenReturn(updatedData);

        //assert
        assertEquals("test", user.getFname());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    void deletUser() {
        when(userDao.findById(1)).thenReturn(Optional.of(new UserModel(1, "test", "test", "test@gmail.com", "1234569870")));
        userServices.deletUser(1);
        verify(userDao, times(1)).deleteById(1);
    }
}