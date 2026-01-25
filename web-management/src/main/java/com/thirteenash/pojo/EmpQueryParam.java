package com.thirteenash.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page = 1;//当前页码，默认值为1
    private Integer pageSize = 10;//每页显示数量，默认值为10
    private String name;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;//
}
