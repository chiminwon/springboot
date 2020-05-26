package com.ming.jpa.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@Entity(name = "t_user")
@Data
@ApiModel
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户Id")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "用户地址")
    private String address;
}
