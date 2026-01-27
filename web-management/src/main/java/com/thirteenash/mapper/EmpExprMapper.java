package com.thirteenash.mapper;

import com.thirteenash.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//员工工作经历
@Mapper
public interface EmpExprMapper {

    void insertBatch(List<EmpExpr> exprList);//批量保存员工工作经历

    void deleteByEmpIds(List<Integer> empIds);
}
