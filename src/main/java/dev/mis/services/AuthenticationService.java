package dev.mis.services;

import dev.mis.daos.UserDAO;
import dev.mis.entities.User;

public class AuthenticationService {
    //separate from User Service due to its lack of dependency on Movie DAO
    private UserDAO userDAO;
    public AuthenticationService(UserDAO userDAO){this.userDAO=userDAO;}
}
