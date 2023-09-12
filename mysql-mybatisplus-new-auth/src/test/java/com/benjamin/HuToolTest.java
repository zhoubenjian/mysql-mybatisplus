package com.benjamin;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.wondersgroup.utils.crypto.CryptoFactory;
import com.wondersgroup.utils.crypto.CryptoType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;

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
//        String encryptStr = sm2.encryptBcd("Hello", KeyType.PublicKey);
        byte[] encryptStr = sm2.encrypt("HELLO".getBytes());
        System.out.println("密文：" + StrUtil.utf8Str(encryptStr));

        // 解密
//        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));
        String decryptStr = StrUtil.utf8Str(sm2.decrypt(encryptStr));
        System.out.println("明文：" + decryptStr);
    }

    @Test
    public void testSm2() {

        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE/Vq6rgOA3ito9xSL9UueI9QI86tRhWRay7M/FwRDXiThCpzXsPZp5weLqp0wHlDSJ+HfkkWbLVTxksz/y3Y1dg==";
        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgrq9f1puGp4hdZmyEruhza80wqqwsP3wtJWqg4FTSwfCgCgYIKoEcz1UBgi2hRANCAAT9WrquA4DeK2j3FIv1S54j1Ajzq1GFZFrLsz8XBENeJOEKnNew9mnnB4uqnTAeUNIn4d+SRZstVPGSzP/LdjV2";
        String result1 = CryptoFactory.getInstance(CryptoType.SM2, privateKey, publicKey, null).encryptToBase64("hello", StandardCharsets.UTF_8);
        System.out.println("result1 = " + result1);
//        //SM2 sm2 = SmUtil.sm2();
//
////        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQg/2gLDwpCSW1vjxW1LMSzI2DSHPIc5ZEOqkdcvgK2V7KgCgYIKoEcz1UBgi2hRANCAAQo76hx2A49KfeGh+XViR4G5d8c61bzozMh7QWUZxpIKtM4OJBAb+Gm0nK3ZEtaO9HOyNLdhn2GEc10uFbrxrRF";
////        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEKO+ocdgOPSn3hofl1YkeBuXfHOtW86MzIe0FlGcaSCrTODiQQG/hptJyt2RLWjvRzsjS3YZ9hhHNdLhW68a0RQ==";
//
//        String result = CryptoFactory.getInstance(CryptoType.SM2, privateKey, null, null).decryptFromBase64("BMxehYDAPk/xZV/nYFbRP3KJW3XWENYsx93tBMvuKnBiv3yOrBDk/78OHTzvjwNancjy1xCHKCrSdksXYYa0gHKV04R3hDaMuBCHh0dUE8KRhGwyBY4mOo1yFwD4wR2qXblxoEaQCQ==", StandardCharsets.UTF_8);

        String result2 = CryptoFactory.getInstance(CryptoType.SM2, privateKey, null, null).decryptFromBase64(result1, StandardCharsets.UTF_8);
        System.out.println(result2);
    }
}
