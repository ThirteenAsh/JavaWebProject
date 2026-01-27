package com.thirteenash.service;

import com.thirteenash.pojo.JobOption;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    JobOption getEmpJobData();
}
