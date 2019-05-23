package org.techtown.loginsystem;

public class User {
    String userID;
    String userPassword;
    String userName;
    String userAge;

    User(){

    }
    User(String userID, String userPassword, String userName, String userAge){
        setUserID(userID);
        setUserPassword(userPassword);
        setUserName(userName);
        setUserAge(userAge);
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAge() {
        return userAge;
    }
}
