package com.benjamin;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class HuToolTest {

    @Test
    public void Sm2Test() {

        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE/Vq6rgOA3ito9xSL9UueI9QI86tRhWRay7M/FwRDXiThCpzXsPZp5weLqp0wHlDSJ+HfkkWbLVTxksz/y3Y1dg==";
        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgrq9f1puGp4hdZmyEruhza80wqqwsP3wtJWqg4FTSwfCgCgYIKoEcz1UBgi2hRANCAAT9WrquA4DeK2j3FIv1S54j1Ajzq1GFZFrLsz8XBENeJOEKnNew9mnnB4uqnTAeUNIn4d+SRZstVPGSzP/LdjV2";

        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);

        // 加密
        String encryptStr = sm2.encryptBcd("Hello", KeyType.PublicKey);
        System.out.println("密文：" + encryptStr);

        // 解密
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));
        System.out.println("明文：" + decryptStr);
    }
}
