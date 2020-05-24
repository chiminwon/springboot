package com.ming.jpa.controller;

import com.ming.jpa.dao.UserDAO;
import com.ming.jpa.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@Api(tags = "用户管理接口")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @PostMapping("/addUser")
    @ApiOperation("增加用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "allen"),
//            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "shanghai")
//    })
    public void addUser(@RequestBody(required = true) User user) {
        userDAO.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    @ApiOperation("根据用户id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "2")
    public void deleteById(@PathVariable(value = "id") Long id) {
        userDAO.deleteById(id);
    }

    @PutMapping("/updateUserById")
    @ApiOperation("根据用户id更新用户")
    public void updateUserById(@RequestBody(required = true) User user) {
        User update_user = userDAO.getOne(user.getId());
        update_user.setUsername(user.getUsername());
        update_user.setAddress(user.getAddress());
        userDAO.flush();
    }

    @GetMapping("/getAllUsers")
    @ApiOperation("查询所有用户")
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @PostMapping("/getUserByAddressEqualsAndIdLessThanEqual")
    @ApiOperation("get Use rBy Address Equals And Id LessThan Equal")
    public List<User> getUserByAddressEqualsAndIdLessThanEqual(@RequestBody User user) {
        return userDAO.getUserByAddressEqualsAndIdLessThanEqual(user.getAddress(), user.getId());
    }

    @GetMapping("/getMaxIdUser")
    @ApiOperation("getMaxIdUser")
    public User getMaxIdUser() {
        return userDAO.maxIdUser();
    }

}
