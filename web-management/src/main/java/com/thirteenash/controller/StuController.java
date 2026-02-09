package com.thirteenash.controller;

import com.thirteenash.anno.Log;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.pojo.Result;
import com.thirteenash.pojo.StuQueryParam;
import com.thirteenash.pojo.Student;
import com.thirteenash.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StuController {

    @Autowired
    private StuService stuService;

    //查询学生数据
    @GetMapping("/students")
    public Result findAll(StuQueryParam stuQueryParam){
        log.info("查询学生数据：{}", stuQueryParam);
        PageResult<Student> result = stuService.findAll(stuQueryParam);
        return Result.success(result);
    }

    //批量删除学员
    @Log
    @DeleteMapping("/students/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids){
        log.info("批量删除学员：{}", ids);
        stuService.deleteByIds(ids);
        return Result.success();
    }

    //添加学员
    @Log
    @PostMapping("/students")
    public Result save(@RequestBody Student student){
        log.info("添加学员：{}", student);
        stuService.save(student);
        return Result.success();
    }

    //根据ID查询学员信息
    @GetMapping("/students/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询学员信息: {}", id);
        Student student = stuService.getById(id);
        return Result.success(student);
    }

    //修改学员信息
    @Log
    @PutMapping("/students")
    public Result update(@RequestBody Student student){
        log.info("修改学员信息: {}", student);
        stuService.update(student);
        return Result.success();
    }

    //违纪处理
    @Log
    @PutMapping("/students/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score){
        log.info("违纪处理: id={}, score={}", id, score);
        stuService.violation(id, score);
        return Result.success();
    }
}
