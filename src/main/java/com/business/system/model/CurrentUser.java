package com.business.system.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;
    private Role role;

    public CurrentUser(User user, Role role) {
        super(user.getUserId(), user.getPassWord(), AuthorityUtils.createAuthorityList(role.getRoleType()));
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    public String getId() {
        return user.getUserId();
    }


    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
