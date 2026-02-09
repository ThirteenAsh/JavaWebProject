package com.thirteenash.controller;

import com.thirteenash.pojo.OperateLog;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.pojo.Result;
import com.thirteenash.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/log/page")
    public Result page(Integer page, Integer pageSize){
        log.info("分页查询：{}", page);
        PageResult<OperateLog> pageResult = logService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
