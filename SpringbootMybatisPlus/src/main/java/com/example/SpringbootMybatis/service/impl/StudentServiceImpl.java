package com.example.SpringbootMybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.SpringbootMybatis.dao.StudentMapper;
import com.example.SpringbootMybatis.domain.bean.Student;
import com.example.SpringbootMybatis.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/14 19:25
 * @Version 1.0
 **/
@Service
@AllArgsConstructor
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements IStudentService {

    private StudentMapper studentMapper;

    @Override
    public int insert(Student student) {
        int result = studentMapper.insert(student);
        return result;
    }

    @Override
    public List<Student> selectStudents() {
        return null;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.selectById(id);
    }
}
