package com.iheima.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import com.iheima.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    public List<User> findAll();

    @Delete("DELETE FROM user WHERE id = #{id}")
    public Integer deleteById(Integer id);

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    public User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
