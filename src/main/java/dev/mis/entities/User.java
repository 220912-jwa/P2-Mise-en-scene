package dev.mis.entities;

public class User {
    public int userID;
    public String username;
    public String pass;
    public String userCode; //could be int, depending upon how we choose to generate it
    public User(){}
    public User(int userID, String username, String pass, String userCode) {
        this.userID = userID;
        this.username = username;
        this.pass = pass;
        this.userCode = userCode;
    }

    public User(String username, String pass, String userCode) {
        this.username = username;
        this.pass = pass;
        this.userCode = userCode;
    }//for account creation

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", userCode='" + userCode + '\'' +
                '}';
    }
}
