package com.example.SpringbootBaseMaven.service.impl;

import com.example.SpringbootBaseMaven.domain.User;
import com.example.SpringbootBaseMaven.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Override
    public List<User> getUserList() {
        ArrayList<User> users = new ArrayList<>();
        initUserList(users);
        System.out.println("user----->" + List.of(users));
        log.info("user----->" + List.of(users));
        return users;
    }


    private void initUserList(List<User> userList) {
        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setName("Tom_" + i);
            user.setAge(20 + i);
            user.setCountry("China");
            user.setSalary((i + 1) * 1000);
            userList.add(user);
        }
    }
}
