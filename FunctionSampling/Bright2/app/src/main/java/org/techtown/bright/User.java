package org.techtown.bright;

public class User {
    String userID, userPassword, userName, userPhone;
    int userAge;

    public User(String userID, String userPassword, String userName, int userAge, String userPhone){
        setUserID(userID);
        setUserPassword(userPassword);
        setUserName(userName);
        setUserAge(userAge);
        setUserPhone(userPhone);
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

    public String getUserPhone() {
        return userPhone;
    }

    public int getUserAge() {
        return userAge;
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

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
