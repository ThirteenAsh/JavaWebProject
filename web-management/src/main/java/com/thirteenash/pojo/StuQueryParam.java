package com.thirteenash.pojo;

import lombok.Data;

@Data
public class StuQueryParam {
    private String name;
    private Integer degree;
    private String clazzName;
    private Integer page = 1;//当前页码，默认值为1
    private Integer pageSize = 10;//每页显示数量，默认值为10

}
