package com.benjamin;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.IdcardUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HutoolTest {

    private final static String idNumber = "321083197812162119";



    @Test
    public void idCardTest() {

        // 是否合法
        System.out.println(IdcardUtil.isValidCard(idNumber));

        // 省份
        System.out.println(IdcardUtil.getProvinceByIdCard(idNumber));

        // 年龄
        System.out.println(IdcardUtil.getAgeByIdCard(idNumber));

        // 脱敏（front：前面隐藏的位数；end：后面隐藏的位数）
        System.out.println(DesensitizedUtil.idCardNum(idNumber, 6, 4));

    }
}
