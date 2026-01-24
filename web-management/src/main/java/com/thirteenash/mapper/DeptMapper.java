package com.thirteenash.mapper;

import com.thirteenash.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 部门Mapper接口,用于访问数据库
@Mapper// Mapper接口 作用 为将接口方法映射成对应的SQL语句
public interface DeptMapper {

    // 查询全部部门数据
    @Select("select id,name,create_time,update_time from dept order by  update_time desc ;")
    List<Dept> findAll();

    // 删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //新增部门
    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    //查询部门
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getId(Integer id);

    //修改部门
    @Update("update dept set name = #{name} ,update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
