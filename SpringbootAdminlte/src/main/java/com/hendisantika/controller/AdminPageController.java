package com.hendisantika.controller;

import com.hendisantika.entity.Order;
import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-adminlte3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/20
 * Time: 08.41
 */
@Controller
//@Slf4j
public class AdminPageController {

    private static final Logger log = LoggerFactory.getLogger(AdminPageController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/user/list", "/admin/user"})
    public String listUser() {
        return "user-list";
    }

    @GetMapping("/user/list2")
    public String listUser2(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user-list2";
    }
    @GetMapping("/releaseNotice/list2")
    public String releaseNotice(Order order, Model model) {
        log.info("releaseNotice...............");
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("order", order);
        return "releaseNotice";
    }


    @GetMapping("/user/add")
    public String showFormUser(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @PostMapping("/user/add")
    public String addUser(Model model, User user) {
        userRepository.save(user);
        model.addAttribute("user", new User());
        return "user-list";
    }

}
