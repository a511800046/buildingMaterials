package com.business.system.service.serviceImpl;

import com.business.system.model.CurrentUser;
import com.business.system.service.CurrentUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @program: saleSystem
 * @description: 对当前登陆人的处理，比如查询此用户权等
 * @author: chengy
 * @create: 2018-11-14 09:18
 **/
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserServiceImpl.class);

    /**
     * 判断当前用户是否有权限
     *
     * @param currentUser 当前登陆用户
     * @param userId
     * @return
     */
    @Override
    public boolean canAccessUser(CurrentUser currentUser, String userId) {
        LOGGER.info("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole().equals("admin") || currentUser.getId().equals(userId));
    }


}
