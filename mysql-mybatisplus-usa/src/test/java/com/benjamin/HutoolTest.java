package com.benjamin;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.IdcardUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HutoolTest {

    private final static String ID_NUMBER = "321083197812162119";

    private final static String MOBILE_PHONE = "19999999999";



    /**
     * 身份证号操作
     */
    @Test
    public void idCardTest() {

        // 是否合法
        System.out.println(IdcardUtil.isValidCard(ID_NUMBER));

        // 省份
        System.out.println(IdcardUtil.getProvinceByIdCard(ID_NUMBER));

        // 年龄
        System.out.println(IdcardUtil.getAgeByIdCard(ID_NUMBER));

        // 脱敏（front：前面隐藏的位数；end：后面隐藏的位数）
        System.out.println(DesensitizedUtil.idCardNum(ID_NUMBER, 6, 4));
    }

    /**
     * 手机号操作
     */
    @Test
    public void mobileTest() {

        // 是否合法
        System.out.println(Validator.isMobile(MOBILE_PHONE));

        // 脱敏
        System.out.println(DesensitizedUtil.mobilePhone(MOBILE_PHONE));
    }
}
