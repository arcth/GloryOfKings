package com.athlete.ranking.controller;

import com.athlete.ranking.domain.WxUser;
import com.athlete.ranking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable String id) {
        WxUser user = userService.selectByOpenId(id);
        System.out.println("1234567890");
        return userService.selectByOpenId(id).toString();
    }
}