package com.thirteenash.controller;

import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpQueryParam;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.pojo.Result;
import com.thirteenash.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//员工管理控制器
@Slf4j
@RequestMapping("/emps")//全局路径
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询：{}",empQueryParam);
        // 调用服务层进行分页查询
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    // 保存员工

    @PostMapping
    public Result save(@RequestBody Emp emp){

        // 保存员工
        log.info("新增员工：{}", emp);
        empService.save(emp);
        return Result.success();
    }

}
