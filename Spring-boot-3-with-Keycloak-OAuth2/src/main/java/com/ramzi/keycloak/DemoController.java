package com.ramzi.keycloak;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    @PreAuthorize("hasRole('view-holidays')")
    public String firstTest(){
        return "Test is valid";
    }

    @GetMapping("/test-2")
    @PreAuthorize("hasRole('client_admin')")
    public String secondTest(){
        return "Test 2 is valid for ADMIN";
    }
}
