package com.thirteenash.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.thirteenash.mapper.EmpMapper;
import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpQueryParam;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {


    private final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        // 1. 设置分页参数
        //注意：这行代码一定要写在查询方法之前！
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 2. 执行查询
        // 返回的 empList 看起来是 List<Emp>，
        // 但实际上它是 PageHelper 封装过的特殊 List
        List<Emp> empList = empMapper.list(empQueryParam);

        // 3. 解析查询结果，封装成 PageResult
        // empList 实际上是 Page 类型（Page 是 List 的子类）这里进行强制类型转换，目的是：获取分页相关的额外信息（如总记录数）
        Page<Emp> p = (Page<Emp>) empList;

        // 返回 PageResult 对象
        // p.getTotal()   ：查询到的“总记录数”（不只是当前页） p.getResult() ：当前页的数据集合
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

}
