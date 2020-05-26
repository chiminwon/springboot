package com.ming.jdbc.service;

import com.ming.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;
import java.util.List;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询的时候需要提供一个 RowMapper，就是需要自己手动映射，将数据库中的字段和对象的属性一一对应起来
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                String username = resultSet.getString("username");
                String address = resultSet.getString("address");
                long id = resultSet.getLong("id");
                User user = new User();
                user.setAddress(address);
                user.setUsername(username);
                user.setId(id);
                return user;
            }
        });
    }

    // 数据库中的字段和对象属性的名字一模一样
    public List<User> getAllUsers2() {
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }

    public int addUser(User user) {
        return jdbcTemplate.update("insert into user (username,address) values (?,?);", user.getUsername(), user.getAddress());
    }

    // 主键回填
    public int addUser2(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int update = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into user (username,address) values (?,?);", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getAddress());
                return ps;
            }
        }, keyHolder);
        user.setId(keyHolder.getKey().longValue());
        System.out.println(user);
        return update;
    }

    public int deleteUserById(Long id) {
        return jdbcTemplate.update("delete from user where id=?", id);
    }
}
