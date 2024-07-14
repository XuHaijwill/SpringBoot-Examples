package com.example.SpringbootMybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.SpringbootMybatis.domain.bean.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName StudentMapper
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/14 18:09
 * @Version 1.0
 **/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}