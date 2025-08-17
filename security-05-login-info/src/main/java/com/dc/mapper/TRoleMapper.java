package com.dc.mapper;

import com.dc.entity.TRole;
import java.util.List;

public interface TRoleMapper {

    TRole selectById(Integer id);

    List<TRole> selectAll();

    int insert(TRole role);

    int updateById(TRole role);

    int deleteById(Integer id);

    List<TRole> selectByUserId(Integer userId);
}
