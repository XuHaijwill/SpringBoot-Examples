package com.example.SpringbootMybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.SpringbootMybatis.domain.bean.Student;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/14 19:24
 * @Version 1.0
 **/
public interface IStudentService extends IService<Student> {

    int insert(Student student);

    List<Student> selectStudents();

    Student getStudentById(Long id);
}
