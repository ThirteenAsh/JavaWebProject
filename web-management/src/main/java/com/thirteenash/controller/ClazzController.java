package com.thirteenash.controller;

import com.thirteenash.pojo.Clazz;
import com.thirteenash.pojo.ClazzQueryParam;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.pojo.Result;
import com.thirteenash.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    //查询所有班级信息（分页查询）
    @GetMapping("/clazzs")
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询所有班级信息");
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    //查询所有班级信息（不分页）- 用于下拉选择等场景
    @GetMapping("/clazzs/list")
    public Result findAll(){
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }

}
