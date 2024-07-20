package com.example.SpringbootThymeleaf.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName GenerateRelease
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/20 15:10
 * @Version 1.0
 **/
@Controller
public class GenerateRelease {

    @GetMapping("/user/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/user/DateTime")
    public String DateTime(Model model) {
        return "DateTime";
    }


}
