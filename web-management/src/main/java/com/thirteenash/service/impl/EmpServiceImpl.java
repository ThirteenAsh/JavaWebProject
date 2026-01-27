package com.thirteenash.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.thirteenash.mapper.EmpExprMapper;
import com.thirteenash.mapper.EmpMapper;
import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpExpr;
import com.thirteenash.pojo.EmpQueryParam;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

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

    @Transactional(rollbackFor = {Exception.class})
    // 声明当前方法为事务方法 事务管理默认出现运行时异常（继承自 RuntimeException）时回滚
    @Override
    public void save(Emp emp) {
        //保存员工的基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        Integer empId = emp.getId();
        //保存员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)){// 判断集合是否为空
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));// 增强for循环，设置员工 ID
            empExprMapper.insertBatch(exprList);
        }
    }


    @Transactional(rollbackFor = {Exception.class})// 声明当前方法为事务方法
    // 批量删除员工
    @Override
    public void delete(List<Integer> ids) {
        //1.删除基本信息
        empMapper.deleteById(ids);
        //2.批量删除员工的工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    // 修改员工
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateById(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }
}
