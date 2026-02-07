package com.thirteenash.mapper;

import com.thirteenash.pojo.StuQueryParam;
import com.thirteenash.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuMapper {

    List<Student> findAll(StuQueryParam stuQueryParam);

    //批量删除学员
    void deleteByIds(List<Integer> ids);

    //添加学员
    void insert(Student student);

    //根据ID查询学员
    Student getById(Integer id);

    //修改学员信息
    void update(Student student);
}
