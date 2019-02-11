package com.business.system.controller;

import com.business.system.service.UserService;
import com.common.constant.JsonResult;
import com.common.util.FastJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public String getUsersPage(Authentication authentication) {
        LOGGER.info("Getting users page");
        // return new JsonResult(userService.getUserById(authentication.getName()));
        Map map = new HashMap();
        map.put("state", "1");
        map.put("message", "成功");
        map.put("data", "1");
        return FastJsonUtil.map2Json(map);
    }

    @RequestMapping(value = "/userJson", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUsersPageJsonResult(Authentication authentication) {
        return new JsonResult(userService.getUserById(authentication.getName()));

    }


}

