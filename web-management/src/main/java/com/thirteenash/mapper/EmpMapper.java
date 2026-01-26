package com.thirteenash.mapper;


import com.thirteenash.pojo.Emp;
import com.thirteenash.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

//员工Mapper
@Mapper
public interface EmpMapper {

//    //查询总记录数
//    @Select("select count(*) from emp e left join dep d on e.dep_id = d.id")
//    public Long count();

    //条件查询员工信息方法，分页
    //@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    List<Emp> list(EmpQueryParam empQueryParam);

    //@Options作用为：将插入的记录的主键值回填到emp对象中，即：将插入的记录的主键值回填到emp对象的id属性中
    //keyProperty 为：指定主键的属性名，keyColumn为：指定主键的列名
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
