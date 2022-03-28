package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.UserModel;
import com.example.SpringBootDemo.services.UserServicesImp;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions.*;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServicesImp userServices;



    @Test
    @Rollback(value = false)
    @Order(1)
    void saveEmployee() {

        //mock
       UserModel userdata = new UserModel();
       userdata.setId(1);
       userdata.setFname("test");
       userdata.setLname("test");
       userdata.setEmail("test@g.c");
       userdata.setMobile("1234567890");

       //mocking
       when(userServices.saveEmployee(userdata)).thenReturn(userdata);

       //test
        UserModel user = userController.saveEmployee(userdata);

        //verify
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getFname()).isEqualTo("test");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    void showUser() {

        //mock
        List<UserModel> userModelList = new ArrayList<>();
        UserModel userone= new UserModel(1,"test","test","test@g.c", "123456789");
        UserModel userteo= new UserModel(2,"test1","test1","test1@g.c", "1346798520");
        UserModel userthree= new UserModel(3,"test2","test2","test2@g.c", "1379864250");

        userModelList.add(userone);
        userModelList.add(userteo);
        userModelList.add(userthree);

        //mocking
        when(userServices.userList()).thenReturn(userModelList);

        //test
        userController.showUser();

        //verify
        verify(userServices, Mockito.times(1)).userList();

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    void singleUser() {

        //mock
        List<UserModel> userModelList = new ArrayList<>();
        UserModel userone= new UserModel(1,"test","test","test@g.c", "123456789");
        UserModel userteo= new UserModel(2,"test1","test1","test1@g.c", "1346798520");
        UserModel userthree= new UserModel(3,"test2","test2","test2@g.c", "1379864250");

        userModelList.add(userone);
        userModelList.add(userteo);
        userModelList.add(userthree);

        //mocking
        when(userServices.userData(1)).thenReturn(userone);
        when(userServices.userData(2)).thenReturn(userteo);
        when(userServices.userData(3)).thenReturn(userthree);

        //test
        UserModel userName = userController.singleUser(2);

        //verify
        assertEquals("test1", userName.getFname());

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    void updateData() {
        //mock
        UserModel userdata = new UserModel();
        userdata.setId(1);
        userdata.setFname("test");
        userdata.setLname("test");
        userdata.setEmail("test@g.c");
        userdata.setMobile("1234567890");

        //mocking
        when(userServices.updateUser(userdata, 1)).thenReturn(userdata);

        //test
        UserModel user = userController.updateData(1,userdata);
        user.setFname("testing");

        //verify
        assertEquals("testing",user.getFname());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    void deleteUser() {

        //Mock
        UserModel userdata = new UserModel();
        userdata.setId(1);
        userdata.setFname("test");
        userdata.setLname("test");
        userdata.setEmail("test@g.c");
        userdata.setMobile("1234567890");

        //mocking
        when(userServices.userData(1)).thenReturn(userdata);

        //test
        userController.deleteUser(1);


        //verify
        verify(userServices, times(1)).deletUser(1);

    }
}