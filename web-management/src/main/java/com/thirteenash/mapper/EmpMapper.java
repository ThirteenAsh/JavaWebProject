package com.thirteenash.mapper;


import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//员工Mapper
@Mapper
public interface EmpMapper {

//    //查询总记录数
//    @Select("select count(*) from emp e left join dep d on e.dep_id = d.id")
//    public Long count();

    //条件查询员工信息方法，分页
    //@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    public List<Emp> list(EmpQueryParam empQueryParam);
}
