package com.thirteenash.controller;

import com.thirteenash.pojo.Dept;
import com.thirteenash.pojo.Result;
import com.thirteenash.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // 日志注解 日志记录
@RestController//注解作用为：将当前类对象，注入到spring容器中，创建对象实例
public class DeptController {

    @Autowired//注解作用为：将当前类对象，注入到spring容器中，创建对象实例
    private DeptService deptService;

    // 查询全部部门数据
    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list(){
        log.info("查询全部的部门数据");
        List< Dept > deptList = deptService.findAll(); //封装 数据
        return Result.success(deptList);
    }

    // 删除部门
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        log.info("根据id删除部门：{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    //新增部门
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){ //@RequestBody注解作用为：将前台发送的json数据，映射为Dept对象
        log.info("新增部门: {}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据ID查询部门
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id){ //@PathVariable注解作用为：将url中的参数，映射为方法参数 即：将url中的{id}参数，映射为id参数
        log.info("根据ID查询数据:{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改 部门
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
