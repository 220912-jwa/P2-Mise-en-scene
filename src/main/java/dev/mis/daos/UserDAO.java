package dev.mis.daos;

import dev.mis.entities.User;

public class UserDAO {

    public User createUser(User user) {
    }//creates a new user in user table
    //needs to use ID-less constructor, and setID afterwards


    public User getUserByUsername(String username) {
    }//used for login

    public User getUserByUserCode(String userCode) {
    }//used for viewing other users' libraries

    public User getUserById(int id){

    }//used for loading library upon login/by mods in later iterations

    public boolean updateUser (User user){

    }//really just used by admin/future password changes, adding movies to list will update junction table alone

    public boolean deleteUser (int id){

    }//needs to be via ID and not publicly shareable User Code

}
