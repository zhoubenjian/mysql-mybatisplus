package com.benjamin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SetTest {

    @Test
    public void setCompare() {

        List<String> A = new ArrayList<String>() {
            {
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("6");
            }
        };

        List<String> B = new ArrayList<String>() {
            {
                add("1");
                add("3");
                add("5");
            }
        };

        List<String> C = new ArrayList<String>() {
            {
                add("2");
                add("4");
                add("6");
            }
        };



        // 差集
        List<String> AB = A.stream().filter(item -> !B.contains(item)).collect(Collectors.toList());
        AB.forEach(System.out::println);
    }
}
