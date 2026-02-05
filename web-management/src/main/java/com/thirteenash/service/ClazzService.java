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
}
