package com.thirteenash.controller;

import com.thirteenash.pojo.Clazz;
import com.thirteenash.pojo.ClazzQueryParam;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.pojo.Result;
import com.thirteenash.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //删除班级
    @DeleteMapping("/clazzs/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("删除了id为{}的班级", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    //添加班级
    @PostMapping("/clazzs")
    public Result addClazz(@RequestBody Clazz clazz){
        log.info("添加班级：{}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    //根据ID查询班级信息
    @GetMapping("/clazzs/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询班级信息: {}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    //修改班级信息
    @PutMapping("/clazzs")
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息: {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

}
