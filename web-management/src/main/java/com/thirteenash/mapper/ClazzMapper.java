package com.thirteenash.mapper;

import com.thirteenash.pojo.Clazz;
import com.thirteenash.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    //班级分页查询
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    //查询所有班级
    List<Clazz> findAll();

}
