package com.example.SpringbootMybatis.service.impl;

import com.example.SpringbootMybatis.SpringbootMybatisApplicationTests;
import com.example.SpringbootMybatis.domain.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class StudentServiceImplTest extends SpringbootMybatisApplicationTests {

    @Autowired
    private StudentServiceImpl studentService;

    @Test
    void insert() {
        Student student1 = new Student().builder().id(1L).age(18).name("Tom").createDateTime(new Date())
                .updateDateTime(new Date()).build();
        int insert = studentService.insert(student1);
        System.out.println("insert result:" + insert);
    }

    @Test
    void selectStudents() {
    }

    @Test
    void getStudentById() {
    }
}