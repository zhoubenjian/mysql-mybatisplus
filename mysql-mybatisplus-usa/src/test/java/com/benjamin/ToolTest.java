package com.benjamin;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ToolTest {

    @Test
    public void sha1() {
        String china = SecureUtil.sha1("china");
        System.out.println(china);
        String China = SecureUtil.sha1("China");
        System.out.println(China);
        System.out.println(China.length());
    }

    @Test
    public void sha256() {
        String china = SecureUtil.sha256("china");
        System.out.println(china);
        String China = SecureUtil.sha256("China");
        System.out.println(China);
        System.out.println(China.length());
    }
}
