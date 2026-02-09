package com.thirteenash.service;

import com.thirteenash.pojo.PageResult;
import com.thirteenash.pojo.StuQueryParam;
import com.thirteenash.pojo.Student;

import java.util.List;

public interface StuService {
    PageResult<Student> findAll(StuQueryParam stuQueryParam);

    //批量删除学员
    void deleteByIds(List<Integer> ids);

    //添加学员
    void save(Student student);

    //根据ID查询学员
    Student getById(Integer id);

    //修改学员信息
    void update(Student student);

    void violation(Integer id, Integer score);
}
