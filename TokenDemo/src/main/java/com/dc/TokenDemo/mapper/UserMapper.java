package com.dc.TokenDemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dc.TokenDemo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
