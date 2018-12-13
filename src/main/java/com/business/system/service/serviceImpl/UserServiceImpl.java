package com.business.system.service.serviceImpl;

import com.business.system.dao.InfoUserDao;
import com.business.system.model.Role;
import com.business.system.model.User;
import com.business.system.model.UserCreateForm;
import com.business.system.service.UserService;
import com.common.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final InfoUserDao infoUserDao;

    @Autowired
    public UserServiceImpl(InfoUserDao infoUserDao) {
        this.infoUserDao = infoUserDao;
    }

    @Override
    public Optional<User> getUserById(String id) {
        LOGGER.info("Getting user={}", id);
        User returnUser = infoUserDao.findUserInfoByUserId(id);
        return Optional.ofNullable(returnUser);
    }


    @Override
    public Collection<User> getAllUsers() {
        List<Map<String, String>> li = infoUserDao.findAllUserInfo();
        List<User> returnList = new ArrayList<>();
        for (Map<String, String> userMap : li) {
            returnList.add(BeanUtil.mapToBean(userMap, User.class));
        }
        LOGGER.info("Getting all users");
        return returnList;
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setUserId(form.getUserId());
        user.setPassWord(form.getPassWord());
        user.setUserName(form.getUserName());
        return infoUserDao.saveUser(user);
    }

    @Override
    public Optional<Role> findUserRoleByUserPrimaryKey(String id) {
        LOGGER.info("Getting role={}", id);
        return Optional.ofNullable(infoUserDao.findUserRoleByUserPrimaryKey(id));
    }

}
