package com.dc.service.impl;

import com.dc.entity.TRole;
import com.dc.entity.TUser;
import com.dc.mapper.TRoleMapper;
import com.dc.mapper.TUserMapper;
import com.dc.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper tUserMapper;

    @Resource
    private TRoleMapper tRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("用户名" + username);
        TUser tUser = tUserMapper.selectByLoginAct(username);
        System.out.println("用户信息" + tUser);
        if (tUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }


        // 根据用户id查询角色信息
        List<TRole> tRoleList = tRoleMapper.selectByUserId(tUser.getId());
        tUser.setTRoleList(tRoleList);  // 将角色信息设置到用户信息中
        return tUser;
    }
}
