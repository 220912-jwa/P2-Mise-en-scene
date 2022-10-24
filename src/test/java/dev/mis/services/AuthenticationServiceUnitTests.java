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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceUnitTests {

@InjectMocks
private static AuthenticationService as;
@Mock
private static UserDAO userDAO;
private User mockRightCombo;
private User mockWrongPass;
private User mockInvalidUsername;

@BeforeAll
    public static void setup(){
    userDAO=new UserDAO();
    as = new AuthenticationService(userDAO);

}
@BeforeEach
public void mockObjects(){
    mockRightCombo = new User(0,"jill42","pw","t42k8j9sg2");
    mockWrongPass = new User(1,"betatester","first","1fh4f92h");
    mockInvalidUsername = new User(3,"testJames","secure_pw","23984gy73ghu20");
}
@Test
public void positiveLogin(){
    when(userDAO.getUserByUsername(mockRightCombo.getUsername())).thenReturn(mockRightCombo);
    User rightCombo =as.login(mockRightCombo.getUsername(),mockRightCombo.getPass());
    assertNotNull(rightCombo);
}
@Test
    public void wrongPass(){}

}
