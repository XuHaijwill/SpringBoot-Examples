package com.example.SpringbootThymeleaf.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName DashboardController
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/20 14:52
 * @Version 1.0
 **/
@Controller
public class DashboardController {

    @GetMapping("/user/generateRelease")
    public String generateRelease(Model model) {
        return "generateRelease";
    }

}
