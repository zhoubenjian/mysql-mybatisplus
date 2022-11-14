package com.benjamin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.benjamin.dao.SysUserMapper;
import com.benjamin.entities.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthTest {

    @Autowired
    private SysUserMapper sysUserMapper;



    @Test
    public void querySysUser() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", "superadmin");
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        System.out.println(sysUser);
    }
}
