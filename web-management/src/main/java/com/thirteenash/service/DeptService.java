package com.thirteenash.service;

import com.thirteenash.pojo.Dept;

import java.util.List;

// 部门Service接口
public interface DeptService {

    // 查询全部部门数据
    List<Dept> findAll();

    // 删除部门
    void deleteById(Integer id);

    // 添加部门
    void add(Dept dept);

    // 查询部门
    Dept getById(Integer id);

    // 更新部门
    void update(Dept dept);
}
