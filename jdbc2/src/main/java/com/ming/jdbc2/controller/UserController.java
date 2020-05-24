package com.min.jdbc.controller;

import com.min.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;

    @Resource(name = "jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;


    @GetMapping("/getAllUsers1")
    public List<User> getAllUsers1() {
        return jdbcTemplateOne.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }

    @GetMapping("/getAllUsers2")
    public List<User> getAllUsers2() {
        return jdbcTemplateTwo.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }
}
