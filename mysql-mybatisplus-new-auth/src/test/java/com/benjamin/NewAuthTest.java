package com.benjamin;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.zip.CheckedOutputStream;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class NewAuthTest {

    // 数字
    public static final String REG_NUMBER = ".*\\d+.*";
    // 小写字母
    public static final String REG_UPPERCASE = ".*[A-Z]+.*";
    // 大写字母
    public static final String REG_LOWERCASE = ".*[a-z]+.*";
    // 特殊符号(~!@#$%^&*()_+|<>,.?/:;'[]{}\)
    public static final String REG_SYMBOL = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";



    @Test
    public void test() {

        Long a = 0L;
        Long b = 1L;

        long c = 0;
        long d = 0;

        System.out.println(a.longValue() == 1);
        System.out.println(a.longValue() == 0);
        System.out.println(a.longValue() == c);
        System.out.println(a == c);
        System.out.println(b.equals(d));
    }

    @Test
    public void checkPassword() {

        String pwd = "!@#  123q".replace(" ", "");

        if (pwd.length() < 8 || pwd.length() > 15) {

            log.info("密码字符长度不符合：8~15");

        } else {

            int count = 0;

            if (pwd.matches(REG_NUMBER))
                count++;

            if (pwd.matches(REG_UPPERCASE))
                count++;

            if (pwd.matches(REG_LOWERCASE))
                count++;

            if (pwd.matches(REG_SYMBOL))
                count++;

            if (count >= 3) {

                log.info("密码符合");

            } else {

                log.info("密码不符合：大写小写/字母，数字，特殊字符！");
            }
        }
    }
}
