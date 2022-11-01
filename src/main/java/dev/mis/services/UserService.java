package dev.mis.services;

import dev.mis.daos.MovieDAO;
import dev.mis.daos.UserDAO;
import dev.mis.entities.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;
    private MovieDAO movieDAO;


    public UserService(UserDAO userDAO, MovieDAO movieDAO) {

        this.userDAO = userDAO;
        this.movieDAO = movieDAO;
    }

    public MovieDAO getMovieDAO(int id) {

        return movieDAO.getById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public User getuserById(int userId) {

        return userDAO.getUserById(userId);
    }

    public boolean updateUser(User toBeUpdated) {
        return userDAO.updateUser(toBeUpdated);
    }

    public User getUserByUserCode(String userCode){
        return userDAO.getUserByUserCode(userCode);
    }

    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }

    public User createUser(User newUser) {
        return userDAO.createUser(newUser);
    }
}


