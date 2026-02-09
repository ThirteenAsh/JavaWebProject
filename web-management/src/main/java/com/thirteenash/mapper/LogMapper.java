package com.thirteenash.mapper;

import com.thirteenash.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {

    List<OperateLog> page();
}
