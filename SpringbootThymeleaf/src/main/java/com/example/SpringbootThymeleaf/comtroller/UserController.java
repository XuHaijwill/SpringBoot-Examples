package com.example.SpringbootThymeleaf.comtroller;

import com.example.SpringbootThymeleaf.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName UserController
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/20 13:14
 * @Version 1.0
 **/
@Controller
public class UserController {

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/user/login")
    public String loginGet(Model model) {
        return "login";
    }

    @PostMapping("/user/login")
    public String loginPost(User user, Model model) {
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("admin");
        if (user1 != null) {
            httpSession.setAttribute("user", user1);
            User name = (User) httpSession.getAttribute("user");
            return "redirect:generateRelease";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }


}
