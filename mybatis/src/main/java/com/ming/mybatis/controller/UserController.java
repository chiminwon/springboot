package com.ming.mybatis.controller;

import com.ming.mybatis.model.User;
import com.ming.mybatis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关接口")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    @ApiOperation("获取所有用户接口")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/getUserById/{id}")
    @ApiOperation("根据id查找用户接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public User getUserById(@RequestParam(value = "id", required = true) Long id) {
        return userService.getUserById(id);
    }
}
