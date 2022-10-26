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

        return  userDAO.getUserById(userId);
    }

    public void updateUser(User toBeUpdated) {
        userDAO.updateUser(toBeUpdated);
    }
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }


}
