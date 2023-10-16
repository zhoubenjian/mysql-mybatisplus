package com.benjamin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RunTest {

    /**
     * 异常终止执行
     */
    @Test
    public void exceptionStopRunTest() {

        for (int i = 0; i < 10; i++) {
            System.out.println(10 / i);
        }
    }

    /**
     * 异常继续执行
     */
    @Test
    public void exceptionContinueRunTest() {

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(10 / i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
