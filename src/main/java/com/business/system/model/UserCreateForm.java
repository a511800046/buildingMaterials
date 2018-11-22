package com.business.system.model;


public class UserCreateForm {


    private String userId = "";

    private String userName = "";


    private String passWord = "";


    private String passWordRepeated = "";


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

    public String getPassWordRepeated() {
        return passWordRepeated;
    }

    public void setPassWordRepeated(String passWordRepeated) {
        this.passWordRepeated = passWordRepeated;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                '}';
    }

}
