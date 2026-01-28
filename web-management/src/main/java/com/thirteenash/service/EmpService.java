package com.thirteenash.service;

import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpQueryParam;
import com.thirteenash.pojo.LoginInfo;
import com.thirteenash.pojo.PageResult;

import java.util.List;

//员工管理业务接口
public interface EmpService {
    PageResult<Emp>  page(EmpQueryParam empQueryParam);

    //保存员工
    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void updateById(Emp emp);

    LoginInfo login(Emp emp);
}
