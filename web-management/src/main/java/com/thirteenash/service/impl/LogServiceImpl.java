package com.thirteenash.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.thirteenash.mapper.LogMapper;
import com.thirteenash.pojo.OperateLog;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OperateLog> list = logMapper.page();
        Page<OperateLog> p = (Page<OperateLog>) list;
        return new PageResult<>(p.getTotal(),p.getResult());
    }
}
