package com.cn.mapper;

import com.cn.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    public User findUserByUsername(@Param("username") String username);
    @Insert("insert into user(username,password,phone,email,age) values(#{username},#{password},#{phone},#{email},#{age})")
    public void insertUser(User user);
    @Delete("delete from user where id = #{id}")
    public void deleteUserById(Long id);
}
