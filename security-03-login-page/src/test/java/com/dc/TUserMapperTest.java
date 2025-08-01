package com.dc;

import com.dc.entity.TUser;
import com.dc.mapper.TUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TUserMapperTest {

    @Autowired
    private TUserMapper userMapper;

    @Test
    void testSelectByLoginAct() {
        TUser user = userMapper.selectByLoginAct("admin");
        assertThat(user).isNotNull();
        System.out.println(user);
    }
}
