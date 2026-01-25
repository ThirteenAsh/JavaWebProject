package com.thirteenash.service;

import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpQueryParam;
import com.thirteenash.pojo.PageResult;

//员工管理业务接口
public interface EmpService {
    public PageResult<Emp>  page(EmpQueryParam empQueryParam);
}
