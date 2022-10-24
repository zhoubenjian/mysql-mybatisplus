package com.benjamin;

import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OssTest {

    @Autowired
    private OSSClient ossClient;



    @Test
    public void deleteOss() {

    }
}
