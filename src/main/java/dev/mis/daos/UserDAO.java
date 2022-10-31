package dev.mis.daos;

import dev.mis.entities.User;
import dev.mis.util.ConnectionUtil;

import java.sql.*;
import java.util.List;

public class UserDAO {

    public User createUser(User user) {

        //creates a new user in user table
        // needs to use ID-less constructor, and setID afterwards
        // also needs to generate a user code
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into mis.users values (?, ?, ?, ?)";
            PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,user.getUserID());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPass());
            ps.setString(4,user.getUserCode());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                return user;
            }else{
                return null;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;

        }
    }

    public User getUserByUsername(String username) {

        try(Connection conn = ConnectionUtil.createConnection()){

            String sql = "select * from  mis.users where username = ?";

            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("user_code"));
                return user;
            }else{
                return null;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;

        }

    }//used for login


    public User getUserByUserCode(String userCode) {

        try(Connection conn = ConnectionUtil.createConnection()){

            String sql = "select * from mis.users where useCode = ?";

            PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(4, userCode);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("user_code"));
                return user;
            }else{
                return null;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;

        }


    }//used for viewing other users' libraries

    public User getUserById(int id) {

        User user;
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from mis.users where user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(

                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("userCode")
                );
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }}//used for loading library upon login/by mods in later iterations

        public boolean updateUser(User user){

            try (Connection conn = ConnectionUtil.createConnection()) {

                String sql = "update mis.users set username=?, pass=?, userCode=?  where user_id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPass());
                ps.setString(3, user.getUserCode());

                int rowCount = ps.executeUpdate();
                if (rowCount == 1) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

    }
    //really just used by admin/future password changes, adding movies to list will update junction table alone

    public boolean deleteUser (int id){

        try (Connection connection = ConnectionUtil.createConnection()) {
            String sql = "delete from mis.users where user_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int rowCount = ps.executeUpdate();
            if (rowCount == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }//needs to be via ID and not publicly shareable User Code

    public List<User> getAll() {
        return null;
    }

}
