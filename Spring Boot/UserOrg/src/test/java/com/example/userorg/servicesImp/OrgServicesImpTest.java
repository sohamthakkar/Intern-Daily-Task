package com.example.userorg.servicesImp;

import com.example.userorg.customException.ResourceNotFound;
import com.example.userorg.dao.OrgDao;
import com.example.userorg.dao.UserDao;
import com.example.userorg.model.Orgenization;
import com.example.userorg.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        //mock
        List<Orgenization> orgList = new ArrayList<>();
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
        orgList.add(orgOne);
        orgList.add(orgTwo);

        //mocking
        when(orgServicesImp.getAllOrg()).thenReturn(orgList);

        //test
        orgServicesImp.getAllOrg();

        //verify
        verify(orgDao, times(1)).findAll();
        assertEquals(2, orgList.size());
    }

    @Test
    void getOneOrg() {
        //Mock
        List<User> userListOne = new ArrayList<>();
        User userOne = new User("test1","test1@g.c", "1346798520");
        User userTwo = new User("test1","test1@g.c", "1346798520");
        User userthree = new User("test1","test1@g.c", "1346798520");
        userListOne.add(userOne);
        userListOne.add(userTwo);
        List<User> userListTwo = new ArrayList<>();
        userListTwo.add(userthree);
        Orgenization orgOne= new Orgenization(1L,"Appwrite",userListOne);
        Orgenization orgTwo= new Orgenization(2L,"Testing",userListTwo);


        //Mocking
        when(orgDao.findById(1L)).thenReturn(Optional.of(orgOne));
        when(orgDao.findById(2L)).thenReturn(Optional.of(orgTwo));

        //test
        Orgenization org = orgServicesImp.getOneOrg(2L);

        //verify
        verify(orgDao, times(1)).findById(2L);
        assertEquals("Testing", org.getOrgName());

    }

    @Test
    void updateOrgenization() {
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

        when(orgDao.findById(1L)).thenReturn(Optional.of(orgOne));
        when(orgDao.findById(2L)).thenReturn(Optional.of(orgTwo));

        //test
        Orgenization org = new Orgenization();
        org.setOrgName("Softvan");
        User updateUser = new User(3L,"test","test1@g.c", "1346798520");
        List<User> updateUserList = new ArrayList<>();
        updateUserList.add(updateUser);
        org.setUsers(updateUserList);
        orgServicesImp.updateOrgenization(2L, orgTwo);

        //verify
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

        //Mocking
        when(orgDao.findById(1L)).thenReturn(Optional.of(orgOne));
        when(orgDao.findById(2L)).thenReturn(Optional.of(orgTwo));

        //test
        orgServicesImp.deleteOrgenization(2L);

        //verify
        verify(orgDao, times(1)).deleteById(2L);
    }

    @Test // UPDATE USER BY ID BUT USER NOT FOUND WITH THIS ID
    void updateUserNotFoundTest() throws Exception {
        // Request
        Long mockUSerId = 1L;
        // Mocks

        ResourceNotFound expectedResponse = new ResourceNotFound("User Not Found With ID : " + mockUSerId);
        // Mocking
        when(orgDao.findById(mockUSerId)).thenThrow(expectedResponse);

        // Test
        ResourceNotFound actualResponse = Assert.assertThrows(ResourceNotFound.class, () -> orgServicesImp.getOneOrg(mockUSerId));

        // Assertion
        Mockito.verify(orgDao, times(1)).findById(mockUSerId);
        assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
    }
    @Test // UPDATE STUDENT BY ID BUT USER NOT FOUND
    void updateuserByIdFaileduserNotFound() {
        // Request
        Long mockUserId = 1L;
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

        // Mocks
        when(orgDao.findById(mockUserId)).thenReturn(Optional.empty());

        // Test
        ResourceNotFound actualResponse = assertThrows(ResourceNotFound.class,
                () -> orgServicesImp.updateOrgenization(mockUserId, orgOne));

        // Assertion
        verify(orgDao, times(1)).findById(mockUserId);
        assertNotNull(actualResponse);



    }

    @Test // GET USER BY ID AND USER NOT FOUND WITH ID TEST
    void getUserByIdNotFoundTest() throws Exception {

        // Request
        Long mockUSerId = 1L;
        // Mocks
        ResourceNotFound expectedResponse = new ResourceNotFound(
                "User Not Found With ID : " + mockUSerId);
        // Mocking
        when(orgDao.findById(mockUSerId)).thenThrow(expectedResponse);

        // Test
        ResourceNotFound actualResponse = Assert.assertThrows(ResourceNotFound.class,
                () -> orgServicesImp.getOneOrg(mockUSerId));

        // Assertion
        Mockito.verify(orgDao, times(1)).findById(mockUSerId);
        assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
    }

    @Test // DELETE USER BY ID AND USER NOT FOUND WITH ID TEST
    void deleteUserByIdFailedUserNotFoundTest() {
        // Request
        Long mockUserId = 1L;

        // Mocks
        when(orgDao.findById(mockUserId)).thenReturn(Optional.empty());

        // Test
        ResourceNotFound actualResponse = assertThrows(ResourceNotFound.class,
                () -> orgServicesImp.deleteOrgenization(mockUserId));
        // Assertion
        System.out.println(actualResponse.getMessage());
        verify(orgDao, times(1)).findById(mockUserId);
        assertNotNull(actualResponse);

    }
}