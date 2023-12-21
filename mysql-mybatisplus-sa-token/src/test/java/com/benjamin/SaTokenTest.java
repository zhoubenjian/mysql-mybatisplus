package com.benjamin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaTokenTest {

    @Test
    public void test() {

        System.out.println(IdUtil.fastSimpleUUID());

        System.out.println(DateUtil.date());
    }
}
