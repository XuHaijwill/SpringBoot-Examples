package com.example.SpringbootBase.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/28 21:28
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String country;
    private String occupation;
    private double salary;
}
