package com.thirteenash.service;

import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpQueryParam;
import com.thirteenash.pojo.PageResult;

//员工管理业务接口
public interface EmpService {
    PageResult<Emp>  page(EmpQueryParam empQueryParam);

    //保存员工
    void save(Emp emp);
}
