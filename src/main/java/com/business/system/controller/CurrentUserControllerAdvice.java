package com.business.system.controller;

import com.business.system.model.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: saleSystem
 * @description: currentUser方法执行之前执行
 * @author: chengy
 * @create: 2018-11-14 09:18
 **/
@ControllerAdvice
public class CurrentUserControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserControllerAdvice.class);

    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication, HttpServletRequest httpServletRequest) {
        if (authentication != null && !httpServletRequest.getRequestURI().equals("/error")) {
            LOGGER.info("用户[{}] 模块[{}]", ((CurrentUser) authentication.getPrincipal()).getUser().getUserName(), httpServletRequest.getRequestURI());
        }
        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
    }


}
