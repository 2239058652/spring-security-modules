package com.dc.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TUser implements Serializable {
    private Integer id;               // 主键
    private String loginAct;          // 登录账号
    private String loginPwd;          // 登录密码
    private String name;              // 姓名
    private String phone;             // 手机号
    private String email;             // 邮箱
    private Integer accountNoExpired; // 账户未过期
    private Integer credentialsNoExpired; // 凭证未过期
    private Integer accountNoLocked; // 账户未锁定
    private Integer accountEnabled;  // 账户启用状态
    private LocalDateTime createTime;  // 创建时间
    private Integer createBy;         // 创建者 ID
    private LocalDateTime editTime;    // 编辑时间
    private Integer editBy;           // 编辑者 ID
    private LocalDateTime lastLoginTime; // 最后登录时间

    @Serial
    private static final long serialVersionUID = 1L;  // 序列化版本号
}
