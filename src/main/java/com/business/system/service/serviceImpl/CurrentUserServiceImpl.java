package com.business.system.service.serviceImpl;

import com.business.system.model.CurrentUser;
import com.business.system.service.CurrentUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, String userId) {
        LOGGER.info("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole().equals("admin") || currentUser.getId().equals(userId));
    }


}
