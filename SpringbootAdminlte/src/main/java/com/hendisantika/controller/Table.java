package com.hendisantika.controller;

import com.alibaba.fastjson.JSONObject;
import com.hendisantika.entity.Result;
import com.hendisantika.entity.ResultResponse;
import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName Table
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/21 16:35
 * @Version 1.0
 **/
@Controller
public class Table {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/resp/data", method = RequestMethod.POST)
    public String writeByResp(Model model) {

        // 将获取的json数据封装一层，然后在给返回
        List<User> userList = userRepository.findAll();

        model.addAttribute("list", userList);
        //写json数据到客户端
        return "table";
    }

}
