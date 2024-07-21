package com.hendisantika.controller;

import com.hendisantika.entity.Order;
import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-adminlte3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/20
 * Time: 08.40
 */
@Controller
public class WebPageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/releaseNotice")
    public String releaseNotice(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("order",new Order());
//        model.addAttribute("users", userRepository.findAll());
        return "releaseNotice";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/table")
    public String table(Model model) {
        return "table";
    }
}
