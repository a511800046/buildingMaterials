package com.business.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @program: example-spring-boot-security
 * @description: 登陆页面跳转控制
 * @author: chengy
 * @create: 2018-11-14 09:18
 **/
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String getHomePage() {
        LOGGER.info("Getting home page");
        return "index";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        LOGGER.info("Getting login page");
        error.ifPresent(u -> LOGGER.info(u));
        return new ModelAndView("login", "error", error);
    }

}
