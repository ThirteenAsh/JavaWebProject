package com.thirteenash.service.impl;

import com.thirteenash.mapper.EmpMapper;
import com.thirteenash.pojo.JobOption;
import com.thirteenash.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    //统计员工工作信息
    public JobOption getEmpJobData() {
        //1.调用mapper方法查询数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();//统计员工工作信息
        //2.组装数据并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    //统计员工性别
    public List<Map<String, Object>> getEmpGenderData(){
        return empMapper.countEmpGenderData();
    }
}
