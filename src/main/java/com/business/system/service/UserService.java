package com.business.system.service;

import com.business.system.model.Role;
import com.business.system.model.User;
import com.business.system.model.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(String id);


    Collection<User> getAllUsers();

    User create(UserCreateForm form);

    Optional<Role> findUserRoleByUserPrimaryKey(String id);
}
