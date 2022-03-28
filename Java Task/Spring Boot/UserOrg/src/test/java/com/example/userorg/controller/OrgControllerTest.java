package com.example.userorg.controller;

import com.example.userorg.model.Orgenization;
import com.example.userorg.model.User;
import com.example.userorg.servicesImp.OrgServicesImp;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrgControllerTest {
    @Mock
    private OrgServicesImp orgServices;

    @InjectMocks
    private OrgController orgController;

    @Test
    @Order(1)
    @Rollback(value = false)
    void addOrganization() {
        //Mock
        List<User> userListOne = new ArrayList<>();
        User userOne = new User(1L,"test1","test1@g.c", "1346798520");
        User userTwo = new User(2L,"test2","test2@g.c", "1346798520");
        User userthree = new User(3L,"test3","test3@g.c", "1346798520");
        userListOne.add(userOne);
        userListOne.add(userTwo);
        List<User> userListTwo = new ArrayList<>();
        userListTwo.add(userthree);
        Orgenization orgOne= new Orgenization(1L,"Appwrite",userListOne);
        Orgenization orgTwo= new Orgenization(2L,"Testing",userListTwo);

        //Mocking
        when(orgServices.saveOrg(orgOne)).thenReturn(orgOne);
        when(orgServices.saveOrg(orgTwo)).thenReturn(orgTwo);

        //Test
        Orgenization org = orgController.addOrganization(orgOne);
        Orgenization orgtwo = orgController.addOrganization(orgTwo);

        //Assert
        Assertions.assertThat(org).isNotNull();
        Assertions.assertThat(org.getOrgName()).isEqualTo("Appwrite");
        Assertions.assertThat(orgtwo).isNotNull();
        Assertions.assertThat(orgtwo.getOrgName()).isEqualTo("Testing");

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    void getAllOrg() {
        //mock

        List<User> userListOne = new ArrayList<>();
        User userOne = new User("test1","test1@g.c", "1346798520");
        User userTwo = new User("test1","test1@g.c", "1346798520");
        User userthree = new User("test1","test1@g.c", "1346798520");
        userListOne.add(userOne);
        userListOne.add(userTwo);
        List<User> userListTwo = new ArrayList<>();
        userListTwo.add(userthree);
        Orgenization orgOne= new Orgenization("Appwrite",userListOne);
        Orgenization orgTwo= new Orgenization("Appwrite",userListTwo);
        List<Orgenization> orgList = new ArrayList<>();
        orgList.add(orgOne);
        orgList.add(orgTwo);

        //mocking
        when(orgServices.getAllOrg()).thenReturn(orgList);

        //test
        List<Orgenization> orgs = orgController.getAllOrg();

        //assert
        Assertions.assertThat(orgs).isNotNull();
        Assertions.assertThat(orgs.size()).isEqualTo(2);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    void getOneOrg() {
        //mock
        List<User> userListOne = new ArrayList<>();
        User userOne = new User(1L,"test1","test1@g.c", "1346798520");
        User userTwo = new User(2L,"test2","test2@g.c", "1346798520");
        User userthree = new User(3L,"test3","test3@g.c", "1346798520");
        userListOne.add(userOne);
        userListOne.add(userTwo);
        List<User> userListTwo = new ArrayList<>();
        userListTwo.add(userthree);
        Orgenization orgOne= new Orgenization(1L,"Appwrite",userListOne);
        Orgenization orgTwo= new Orgenization(2L,"Testing",userListTwo);

        //mocking
        when(orgServices.getOneOrg(1L)).thenReturn(orgOne);
        when(orgServices.getOneOrg(2L)).thenReturn(orgTwo);

        //test
        Orgenization org = orgController.getOneOrg(1L);
        Orgenization orgtwo = orgController.getOneOrg(2L);

        //assert
        verify(orgServices,times(1)).getOneOrg(1L);
        verify(orgServices,times(1)).getOneOrg(2L);
        assertEquals("Appwrite",org.getOrgName());

    }

    @Test
    void updateOrgenization() {
        //mock
        List<User> userListOne = new ArrayList<>();
        User userOne = new User(1L,"test1","test1@g.c", "1346798520");
        User userTwo = new User(2L,"test2","test2@g.c", "1346798520");
        User userthree = new User(3L,"test3","test3@g.c", "1346798520");
        userListOne.add(userOne);
        userListOne.add(userTwo);
        List<User> userListTwo = new ArrayList<>();
        userListTwo.add(userthree);
        Orgenization orgOne= new Orgenization(1L,"Appwrite",userListOne);
        Orgenization orgTwo= new Orgenization(2L,"Testing",userListTwo);

        //mocking
        //when(orgServices.getOneOrg(1L)).thenReturn(orgOne);
        when(orgServices.getOneOrg(2L)).thenReturn(orgTwo);

        //test

        Orgenization org = new Orgenization();
        org.setOrgName("Softvan");
        User updateUser = new User(3L,"test","test1@g.c", "1346798520");
        List<User> updateUserList = new ArrayList<>();
        updateUserList.add(updateUser);
        org.setUsers(updateUserList);
        orgController.updateOrgenization(2L,orgTwo);

        //assert
        assertEquals("Softvan", org.getOrgName());
    }

    @Test
    void deleteOrgenization() {
        //Mock
        List<User> userListOne = new ArrayList<>();
        User userOne = new User(1L,"test1","test1@g.c", "1346798520");
        User userTwo = new User(2L,"test2","test2@g.c", "1346798520");
        User userthree = new User(3L,"test3","test3@g.c", "1346798520");
        userListOne.add(userOne);
        userListOne.add(userTwo);
        List<User> userListTwo = new ArrayList<>();
        userListTwo.add(userthree);
        Orgenization orgOne= new Orgenization(1L,"Appwrite",userListOne);
        Orgenization orgTwo= new Orgenization(2L,"Testing",userListTwo);

        //mocking
        when(orgServices.getOneOrg(1L)).thenReturn(orgOne);
        when(orgServices.getOneOrg(2L)).thenReturn(orgTwo);

        //test
        orgController.deleteOrgenization(2L);

        //assert
        verify(orgServices, times(1)).deleteOrgenization(2L);
    }
}