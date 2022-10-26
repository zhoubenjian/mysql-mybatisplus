package com.benjamin.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@Accessors(chain = true)
@ConfigurationProperties(prefix = "alibaba.cloud")      // 读取alibaba.cloud对应的配置数据
public class OssConfig {

    private String accessKey;

    private String secretKey;

    private String bucketName;

    private Oss oss;
}
