package com.dc.util;

import com.dc.entity.TUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginInfoUtil {

    /**获取当前登录人信息
     *
     * @return TUser
     */
    public static TUser getCurrentLoginUser() {
        return (TUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
