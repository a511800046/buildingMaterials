package com.business.system.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getUserId(), user.getPassWord(), AuthorityUtils.createAuthorityList(Role.ADMIN.toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return user.getUserId();
    }

    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
