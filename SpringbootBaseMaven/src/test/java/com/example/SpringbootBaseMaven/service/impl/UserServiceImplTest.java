package com.example.SpringbootBaseMaven.service.impl;

import com.example.SpringbootBaseMaven.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Test
    void getUserList() {
        userService.getUserList();
    }
}