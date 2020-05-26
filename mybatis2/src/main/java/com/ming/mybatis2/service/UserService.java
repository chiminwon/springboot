package com.ming.mybatis2.service;

import com.ming.mybatis2.mapper1.UserMapper1;
import com.ming.mybatis2.mapper2.UserMapper2;
import com.ming.mybatis2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper1 userMapper1;

    @Autowired
    private UserMapper2 userMapper2;

    //查询的时候需要提供一个 RowMapper，就是需要自己手动映射，将数据库中的字段和对象的属性一一对应起来
    public List<User> getAllUsers1() {
        return userMapper1.getAllUsers();
    }

    public List<User> getAllUsers2() {
        return userMapper2.getAllUsers();
    }

}
