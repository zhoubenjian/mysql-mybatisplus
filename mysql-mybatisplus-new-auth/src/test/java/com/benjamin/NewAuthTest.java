package com.benjamin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class NewAuthTest {

    @Test
    public void test() {

        Long a = 0L;
        Long b = 1L;

        long c = 0;
        long d = 1;

        System.out.println(a == c);
        System.out.println(b.equals(d));
    }
}
