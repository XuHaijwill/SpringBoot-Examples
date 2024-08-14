package com.example.SpringbootBaseMaven.service;

import com.example.SpringbootBaseMaven.domain.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface IUserService {

    List<User> getUserList();
}
