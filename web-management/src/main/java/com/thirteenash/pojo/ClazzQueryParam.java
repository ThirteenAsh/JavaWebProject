package com.thirteenash.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {

    /** 班级名称 */
    private String name;

    /** 开课时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDateStart;

    /** 结课时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDateEnd;

    /** 当前页 */
    private Integer page = 1;

    /** 每页条数 */
    private Integer pageSize = 10;
}
