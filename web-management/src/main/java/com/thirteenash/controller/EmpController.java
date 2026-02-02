package com.thirteenash.controller;

import com.thirteenash.anno.Log;
import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpQueryParam;
import com.thirteenash.pojo.PageResult;
import com.thirteenash.pojo.Result;
import com.thirteenash.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//员工管理控制器
@Slf4j
@RequestMapping("/emps")//全局路径
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    //分页查询员工数据
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

//    @DeleteMapping
//    public Result delete(Integer[] ids){
//        log.info("删除员工：{}", Arrays.toString(ids));
//        return Result.success();
//    }

    //批量删除员工
    @Log
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工：{}", ids);
        empService.delete(ids);
        return Result.success();
    }


    // 根据id查询员工信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工信息: {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success((emp));
    }

    // 更新员工信息
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息：{}", emp);
        empService.updateById(emp);
        return Result.success();
    }
}
