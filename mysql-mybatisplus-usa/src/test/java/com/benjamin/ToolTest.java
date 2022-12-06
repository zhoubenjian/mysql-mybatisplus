package com.benjamin;

import cn.hutool.crypto.SecureUtil;
import com.benjamin.util.DateToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;

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

    @Test
    public void time() throws ParseException {
        String dateStr = DateToolUtil.getDateStr(DateToolUtil.HH_MM_SS);
        System.out.println(dateStr);

        System.out.println("*****************************************");

        Date date1 = DateToolUtil.DateStr2Date("2022-12-06 12:05:00");
        Date date2 = DateToolUtil.DateStr2Date("2022-12-06 22:05:00");
        long diff = DateToolUtil.diffDate(date1, date2, DateToolUtil.MINUTE);
        System.out.println(diff);
    }
}
