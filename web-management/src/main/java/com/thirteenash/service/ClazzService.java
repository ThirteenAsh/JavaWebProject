package com.thirteenash.service;

import com.thirteenash.pojo.Clazz;
import com.thirteenash.pojo.ClazzQueryParam;
import com.thirteenash.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    //分页查询所有班级信息
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    //查询所有班级信息
    List<Clazz> findAll();

    void deleteById(Integer id);

    void add(Clazz clazz);

    //根据ID查询班级
    Clazz getById(Integer id);

    //修改班级信息
    void update(Clazz clazz);
}
