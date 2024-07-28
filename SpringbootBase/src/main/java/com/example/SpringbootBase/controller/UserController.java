package com.example.SpringbootBase.controller;

import com.example.SpringbootBase.domain.User;
import com.example.SpringbootBase.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/28 21:33
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList() {
        return userService.getUserList();
    }

}
