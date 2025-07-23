package src.main.java.com.dc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表(user)实体类
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static final long serialVersionUID = -40356785423868312L;
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
    private String createTime;
    private String updateBy;
    private String updateTime;
    private Integer delFlag;
}
