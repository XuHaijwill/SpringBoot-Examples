package com.example.SpringbootBase.service;

import com.example.SpringbootBase.domain.User;

import java.util.List;

/**
 * @ClassName IUserService
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/28 21:39
 * @Version 1.0
 **/
public interface IUserService {

    List<User> getUserList();
}
