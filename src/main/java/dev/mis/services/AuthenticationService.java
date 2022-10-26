package dev.mis.services;

import dev.mis.daos.UserDAO;
import dev.mis.entities.User;

public class AuthenticationService {
    //separate from User Service due to its lack of dependency on Movie DAO
    private UserDAO userDAO;
    public AuthenticationService(UserDAO userDAO){this.userDAO=userDAO;}
    public User userLogin(String username, String pass){
        User u = userDAO.getUserByUsername(username);
        if (u.getPass().equals(pass)){
            return u;
        }
        return null;
    }
}
