package com.example.userorg.servicesImp;

import com.example.userorg.dao.OrgDao;
import com.example.userorg.dao.UserDao;
import com.example.userorg.model.Orgenization;
import com.example.userorg.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrgServicesImpTest {

    @Mock
    OrgDao orgDao;

    @InjectMocks
    OrgServicesImp orgServicesImp;

    @Test
    void saveOrg() {
        //Mock
        Orgenization org = new Orgenization();
        org.setOrgName("test");
        User user = new User();
        user.setUserId(1L);
        user.setUserName("test");
        user.setUserEmail("test@g.c");
        user.setUserMobile("9587463210");

        List<User> addUser = new ArrayList<>();
        addUser.add(user);
        org.setUsers(addUser);

        //Mocking
        when(orgServicesImp.saveOrg(org)).thenReturn(org);

        //test
        orgServicesImp.saveOrg(org);

        //verify
        verify(orgDao, times(1)).save(org);
        Assertions.assertThat(org.getOrgName()).isEqualTo("test");
    }

    @Test
    void getAllOrg() {
    }

    @Test
    void getOneOrg() {
    }

    @Test
    void updateOrgenization() {
    }

    @Test
    void deleteOrgenization() {
    }
}