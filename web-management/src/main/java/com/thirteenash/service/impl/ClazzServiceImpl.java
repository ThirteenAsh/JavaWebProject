package com.thirteenash.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.thirteenash.mapper.ClazzMapper;
import com.thirteenash.pojo.Clazz;
import com.thirteenash.pojo.ClazzQueryParam;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    //查询所有班级信息
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> list = clazzMapper.list(clazzQueryParam);
        Page<Clazz> p = (Page<Clazz>) list;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void add(Clazz clazz) {
        clazzMapper.add(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }
}
