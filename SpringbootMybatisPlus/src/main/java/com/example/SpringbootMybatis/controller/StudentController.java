package com.example.SpringbootMybatis.controller;

import com.example.SpringbootMybatis.domain.bean.Student;
import com.example.SpringbootMybatis.service.IStudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName StudentController
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/14 20:09
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@RestController("student")
public class StudentController {

    public IStudentService IStudentService;

    @GetMapping("/insertStudent")
    public int insertStudent(){
        Student student1 = new Student().builder().id(1L).age(18).name("Tom").createDateTime(new Date())
                .updateDateTime(new Date()).build();
        int insert = IStudentService.insert(student1);
        return insert;
    }
}
