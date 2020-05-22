package com.ming.mybatis.mapper;

import com.ming.mybatis.model.User;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getAllUsers();


}
