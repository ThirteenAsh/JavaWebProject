package com.thirteenash.controller;

import com.thirteenash.pojo.JobOption;
import com.thirteenash.pojo.Result;
import com.thirteenash.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    //统计员工工作信息
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
}
