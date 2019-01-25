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
 * @program: saleSystem
 * @description: 登陆页面跳转控制
 * @author: chengy
 * @create: 2018-11-14 09:18
 **/
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登陆成功后的首页
     *
     * @return index.ftl
     */
    @RequestMapping("/")
    public String getIndexPage() {
        LOGGER.info("Getting index page");
        return "system/index";
    }


    /**
     * 登陆页面，通过security框架控制
     *
     * @param error 当登陆名或密码不符时，通过error来进行页面的提示
     * @return login.ftl
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        LOGGER.info("Getting login page, error={}", error);
        return new ModelAndView("system/login", "error", error);
    }

    /**
     * 登陆到系统后iframem默认的首页
     *
     * @return 返回首页 system/homePage.ftl
     */
    @RequestMapping("/system/homePage")
    public String getHomePage() {
        LOGGER.info("Getting Home page");
        return "system/homePage";
    }

}
