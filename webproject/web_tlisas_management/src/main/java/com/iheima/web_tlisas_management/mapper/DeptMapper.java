package com.iheima.web_tlisas_management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iheima.web_tlisas_management.pojo.Dept;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeptMapper {

    
    /* When the column name is the same as the field name, contributes are automatically mapped.
     * But when the column name is different from the field name, we need to manually map the column name to the field name.
     * @Result(
     * {column="create_time", property="createTime,
     * {column="update_time", property="updateTime"
     * }")
     * Also, alias is used to map the column name to the field name.
     * Last but the most common way is to set camel case in the .yml file.
     */
    // Query all departments
    @Select("SELECT id, name, create_time , update_time FROM dept order by update_time desc")
    List<Dept> findAll();

    @Delete("DELETE FROM dept WHERE id = #{id}")
    void deleteById(Integer id);

    @Insert("INSERT INTO dept (name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    @Select("SELECT id, name, create_time , update_time FROM dept WHERE id = #{id}")
    Dept getById(Integer id);

    @Update("UPDATE dept SET name = #{name}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Dept dept);

}
 