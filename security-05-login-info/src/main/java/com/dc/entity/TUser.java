package com.dc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class TUser implements Serializable, UserDetails {
    private Integer id;               // 主键

    private String loginAct;          // 登录账号

    @JsonIgnore
    private String loginPwd;          // 登录密码
    private String name;              // 姓名
    private String phone;             // 手机号
    private String email;             // 邮箱
    private Integer accountNoExpired; // 账户未过期
    private Integer credentialsNoExpired; // 凭证未过期
    private Integer accountNoLocked; // 账户未锁定
    private Integer accountEnabled;  // 账户启用状态

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;  // 创建时间
    private Integer createBy;         // 创建者 ID
    private LocalDateTime editTime;    // 编辑时间
    private Integer editBy;           // 编辑者 ID
    private LocalDateTime lastLoginTime; // 最后登录时间

    // 用户角色列表
    @JsonIgnore
    private List<TRole> tRoleList;

    @Serial
    private static final long serialVersionUID = 1L;  // 序列化版本号

    // --------------------------------------
    // UserDetails 接口方法

    @Override
    public boolean isEnabled() {
        return this.accountEnabled == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNoExpired == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNoLocked == 1;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNoExpired == 1;
    }

    @Override
    public String getUsername() {
        return this.loginAct;
    }

    @Override
    public String getPassword() {
        return this.loginPwd;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (TRole tRole : this.tRoleList) {
            authorities.add(new SimpleGrantedAuthority(tRole.getRole()));
        }
        return authorities;
    }
}
