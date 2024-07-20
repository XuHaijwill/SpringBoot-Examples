package com.example.SpringbootThymeleaf.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/20 14:34
 * @Version 1.0
 **/
@Data
public class User{
    private int id;
    private String userName;
    private String password;
    private String realName;
    private String  business;
    private String email;
    private String headPicture;
    private Date addDate;
    private Date updateDate;
    private int state;
}