package com.benjamin;

import com.aliyun.oss.OSSClient;
import com.benjamin.config.OssConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)        // 单元测试不加，提示空指针异常
public class OssTest {

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private OssConfig ossConfig;



    @Test
    public void testReadYaml() {
        log.info(ossConfig.toString());
    }
}
