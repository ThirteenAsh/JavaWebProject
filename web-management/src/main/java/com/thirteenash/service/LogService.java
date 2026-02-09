package com.thirteenash.service;

import com.thirteenash.pojo.OperateLog;
import com.thirteenash.pojo.PageResult;

public interface LogService {

    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
