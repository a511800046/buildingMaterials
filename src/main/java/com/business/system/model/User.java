package com.business.system.model;


public class User {


    private String id;


    private String userId;

    private String userName;

    private String passWord;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId +
                ", userName='" + userName +
                ", passWord=" + passWord +
                '}';
    }
}
