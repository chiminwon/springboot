package com.ming.mybatis2.controller;

import com.ming.mybatis2.model.User;
import com.ming.mybatis2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers1")
    public List<User> getAllUsers1() {
        return userService.getAllUsers1();
    }

    @GetMapping("/getAllUsers2")
    public List<User> getAllUsers2() {
        return userService.getAllUsers2();
    }
}
