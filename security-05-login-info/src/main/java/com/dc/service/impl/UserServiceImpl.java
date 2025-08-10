package com.dc.service.impl;

import com.dc.entity.TUser;
import com.dc.mapper.TUserMapper;
import com.dc.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper tUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("用户名" + username);
        TUser tUser = tUserMapper.selectByLoginAct(username);
        System.out.println("用户信息" + tUser);
        if (tUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        return tUser;
    }
}
