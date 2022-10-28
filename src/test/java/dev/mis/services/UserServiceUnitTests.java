package dev.mis.services;

import dev.mis.daos.UserDAO;
import dev.mis.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTests {
    @InjectMocks
    private static UserService us;
    @Mock
    private static UserDAO userDAO;
    private static User mockUser;
    private static User mockFullUser;

    @BeforeAll
    public static void setup(){
        userDAO = new UserDAO();
        //us = new UserService(userDAO);

    }
    @BeforeEach
    public void mockObjectsBeforeEach(){
        mockUser = new User("testUser","passpass","t23y982"); //as is, userCode is being generated on frontend
        mockFullUser = new User(7,"testUser","passpass","t23y982");
    }
    /*@Test
    public void testCreateUser(){
        when(userDAO.createUser(mockUser)).thenReturn(mockFullUser);
        User newUser = us.createUser(mockUser);
        assertNotNull(newUser);
    }
    @Test
    public void testGetById(){
        when(userDAO.getUserById(7)).thenReturn(mockFullUser);
        User userGot = us.getUserById(7);
        assertNotNull(userGot);
    }
    @Test
    public void testGetByCode(){
        when(userDAO.getUserByUserCode("t23y982")).thenReturn(mockFullUser);
        User userGot = us.getUserByUserCode("t23y982");
        assertNotNull(userGot);
    }
    @Test
    public void testDeleteUser(){
        when(userDAO.deleteUser(7)).thenReturn(true);
        boolean deleted = us.deleteUser(7);
        assertTrue(deleted);
    }
    @Test
    public void testUpdateUser(){
        when(userDAO.updateUser(mockFullUser)).thenReturn(true);
        boolean updated = us.updateUser(mockFullUser);
        assertTrue(updated);
    }*/

}
