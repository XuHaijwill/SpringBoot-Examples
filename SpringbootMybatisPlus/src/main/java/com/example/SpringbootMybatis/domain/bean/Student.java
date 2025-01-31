package com.example.SpringbootMybatis.domain.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Student
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/14 18:06
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;

    private Integer age;

    private String name;

    private Date createDateTime;

    private Long createUserId;

    private String createUserName;

    private Date updateDateTime;
}
