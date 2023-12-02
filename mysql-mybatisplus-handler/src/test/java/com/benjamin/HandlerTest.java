package com.benjamin;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HandlerTest {

    @Test
    public void chineseTest() {

        System.out.println(Validator.isChinese("唐三"));

        System.out.println(Validator.isChinese("唐C"));
    }

    @Test
    public void test() {

        String content = "18888888888";
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, "[B@2122b4bdchina".getBytes());

        // 加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println("16进制密文：" + encryptHex);

        // 解密为字符串
        String decryptStr = aes.decryptStr(encryptHex);
        System.out.println("原文：" + decryptStr);
    }

    @Test
    public void createNo() {

        // 携带'-'的UUID
        System.out.println(IdUtil.randomUUID());

        // 无'-'的UUID
        System.out.println(IdUtil.simpleUUID());
    }

    @Test
    public void aesTest() {

        String content = "341125199408230399";

        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        System.out.println("key：" + key);

        // 构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

//        // 加密
//        byte[] encrypt = aes.encrypt(content);
//        // 解密
//        byte[] decrypt = aes.decrypt(encrypt);

        // 加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println("16进制密文：" + encryptHex);

        // 解密为字符串
        String decryptStr = aes.decryptStr(encryptHex);
        System.out.println("原文：" + decryptStr);
    }

    @Test
    public void desTest() {

        String content = "19999999999";

        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();
        System.out.println(key);

        // 构建
        DES des = SecureUtil.des(key);

        // 加密解密
        byte[] encrypt = des.encrypt(content);
        byte[] decrypt = des.decrypt(encrypt);

        // 加密为16进制，解密为原字符串
        String encryptHex = des.encryptHex(content);
        System.out.println("DES加密 16进制密文：" + encryptHex);

        String decryptStr = des.decryptStr(encryptHex);
        System.out.println("DES解密 原文：" + decryptStr);
    }
}
