package com.thirteenash.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.thirteenash.mapper.StuMapper;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.pojo.StuQueryParam;
import com.thirteenash.pojo.Student;
import com.thirteenash.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    //查询所有学生信息（分页查询）
    @Override
    public PageResult<Student> findAll(StuQueryParam stuQueryParam) {
        PageHelper.startPage(stuQueryParam.getPage(), stuQueryParam.getPageSize());
        List<Student> list = stuMapper.findAll(stuQueryParam);
        Page<Student> p = (Page<Student>)list;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    //批量删除
    @Override
    public void deleteByIds(List<Integer> ids) {
        stuMapper.deleteByIds(ids);
    }


    //添加学生
    @Override
    public void save(Student student) {
        // 设置默认值
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        
        stuMapper.insert(student);
    }

    //根据ID查询学生信息
    @Override
    public Student getById(Integer id) {
        return stuMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        // 设置更新时间
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.update(student);
    }

    @Override
    public void violation(Integer id, Integer score) {
        stuMapper.violation(id, score);
    }
}
