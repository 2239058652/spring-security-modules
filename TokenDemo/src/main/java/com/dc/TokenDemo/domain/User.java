package com.dc.TokenDemo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户表(user)实体类
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User {
    private static final long serialVersionUID = -40356785423868312L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String nickName;
    private String password;
    private Integer status;
    private String email;
    private String phone;
    private String sex;
    private String avatar;
    private String userType;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private Integer delFlag;
}