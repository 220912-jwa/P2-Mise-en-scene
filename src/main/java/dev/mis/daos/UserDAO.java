package dev.mis.daos;

import dev.mis.entities.User;
import dev.mis.util.ConnectionUtil;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User createUser(User user) {
        //creates a new user in user table
        // needs to use ID-less constructor, and setID afterwards
        // also needs to generate a user code
    }

    public User getUserByUsername(String username) {

        String sql = "SELECT username, pass, user_code FROM mis.users WHERE username = ?";

        try (Connection connection = ConnectionUtil.createConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return new User(
                  rs.getString("username"),
                  rs.getString("pass"),
                  rs.getString("user_code")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
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
