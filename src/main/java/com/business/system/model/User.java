package com.business.system.model;


public class User {

    /**
     * 32位UUID主键
     */
    private String id;

    /**
     * 用户登陆ID
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户登陆密码
     */
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
