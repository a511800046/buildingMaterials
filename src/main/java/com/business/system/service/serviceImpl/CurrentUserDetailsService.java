package com.business.system.service.serviceImpl;

import com.business.system.model.CurrentUser;
import com.business.system.model.User;
import com.business.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String userId) throws UsernameNotFoundException {
        LOGGER.info("Authenticating user with userId={}", userId);
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with userId=%s was not found", userId)));
        return new CurrentUser(user);
    }

}
