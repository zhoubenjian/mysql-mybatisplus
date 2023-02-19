package com.benjamin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.benjamin.dao.SysUserMapper;
import com.benjamin.entities.SysUser;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
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

    /**
     * 盐值加密
     */
    @Test
    public void sha() {
        String password1 = "xia0yu1994";
        String salt = "ekMmHXRcF6T5XLtwGr8";
                // new SecureRandomNumberGenerator().nextBytes(19).toString();
        int times = 7;
        SimpleHash encodePassword = new SimpleHash("SHA-256", password1, salt, times);
        System.out.println("原始密码：" + password1 + "；\n" +
                "加密方式：SHA-256；\n" +
                "盐值：" + salt + "；\n" +
                "123456加密后密码：" + encodePassword);

        String password2 = "12345";
        System.out.println(" 12345加密后密码：" + new SimpleHash("SHA-256", password2, salt, times));
    }
}
