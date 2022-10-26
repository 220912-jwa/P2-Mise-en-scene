package dev.mis.services;

import dev.mis.daos.MovieDAO;
import dev.mis.daos.UserDAO;

public class UserService {
    private UserDAO userDAO;
    private MovieDAO movieDAO;
    public UserService(){}
    public UserService(UserDAO userDAO, MovieDAO movieDAO){
        this.userDAO=userDAO;
        this.movieDAO=movieDAO;
    }
}
