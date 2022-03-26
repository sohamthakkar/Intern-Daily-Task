package com.example.userorg.dao;

import com.example.userorg.model.Orgenization;
import com.example.userorg.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class OrgDaoTest {

    @Autowired
    private OrgDao orgDao;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveOrgTest(){
        //Mock
         Orgenization org = new Orgenization();
         org.setOrgName("Test Org");

         User user = new User();
         user.setUserName("Test");
         user.setUserEmail("test@g.c");
         user.setUserMobile("3164978520");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        org.setUsers(userList);

        //test
        orgDao.save(org);

        //verify
        Assertions.assertThat(org.getOrgName()).isEqualTo("Test Org");
     }

     @Test
     @Rollback(value = false)
     @Order(2)
     public void findOrgsTest(){
        //Mock & test
         List<Orgenization> org = orgDao.findAll();

         //Assert
         Assertions.assertThat(org).isNotEmpty();
     }

     @Test
     @Order(3)
     @Rollback(value = false)
     public void findOneOrtest(){
         //Mock
         Optional<Orgenization> org = orgDao.findById(3L);

         //Assert
         Assertions.assertThat(org.get().getOrgName()).isEqualTo("Test Org");
     }

     @Test
     @Order(4)
     @Rollback(value = false)
     public void updateOrgTest(){
         //Mock
         Orgenization org =  orgDao.findById(3L).get();
         User user = new User();
         user.setUserId(3L);
         user.setUserName("test");
         user.setUserEmail("test@g.c");
         user.setUserMobile("9632587410");
         List<User> userList = new ArrayList<>();
         userList.add(user);


         //test
         org.setOrgName("testing");
         org.setUsers(userList);
         orgDao.save(org);



         //verify
         Optional<Orgenization> orgenization = orgDao.findById(3L);

         //Assert
         Assertions.assertThat(orgenization.get().getOrgName()).isEqualTo("testing");
     }

     @Test
     @Order(5)
     @Rollback(value = false)
     public void deleteOrgTesting(){
         Orgenization orgenization = orgDao.findById(3L).get();
         orgDao.delete(orgenization);

         Orgenization org1 = null;

         Optional<Orgenization> userData = orgDao.findById(3l);
         if(userData.isPresent()){
             org1 = userData.get();
         }
         Assertions.assertThat(org1).isNull();
     }


}
