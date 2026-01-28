package com.thirteenash.controller;

import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.LoginInfo;
import com.thirteenash.pojo.Result;
import com.thirteenash.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("登录：{}", emp);
        LoginInfo info = empService.login(emp);
        if (info != null){
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }

}
