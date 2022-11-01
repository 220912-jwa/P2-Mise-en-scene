package dev.mis.services;

import dev.mis.daos.MovieDAO;
import dev.mis.daos.UserDAO;
import dev.mis.entities.User;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Random;
public class UserService {
    private UserDAO userDAO;
    private MovieDAO movieDAO;

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public UserService(UserDAO userDAO, MovieDAO movieDAO) {

        this.userDAO = userDAO;
        this.movieDAO = movieDAO;
    }

    public MovieDAO getMovieDAO(int id) {

        return movieDAO.getById(id);
    }

    public String generateUserCode(){
        StringBuilder code = new StringBuilder();

        int n = 0;
        for(int i=0; i < 10; i++){
            n = getRandomNumber();
            char ch = CHAR_LIST.charAt(n);
            code.append(ch);
        }
        return code.toString();
    }

    private int getRandomNumber(){
        int random = 0;
        Random randomGenerator = new Random();
        random = randomGenerator.nextInt(CHAR_LIST.length());
        if(random - 1 == -1){
            return random;
        }
        else{
            return random - 1;
        }
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public User getuserById(int userId) {

        return userDAO.getUserById(userId);
    }

    public void updateUser(User toBeUpdated) {
        userDAO.updateUser(toBeUpdated);
    }

    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}
