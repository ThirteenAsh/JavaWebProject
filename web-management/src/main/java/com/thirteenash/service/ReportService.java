package com.thirteenash.service;

import com.thirteenash.pojo.JobOption;
import com.thirteenash.pojo.StuOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {

    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<Map<String, Object>> getStudentDegreeData();

    StuOption getStudentCountData();
}
