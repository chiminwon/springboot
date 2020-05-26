package com.ming.mybatis.service;

import com.ming.mybatis.mapper.UserMapper;
import com.ming.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //查询的时候需要提供一个 RowMapper，就是需要自己手动映射，将数据库中的字段和对象的属性一一对应起来
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }

}
