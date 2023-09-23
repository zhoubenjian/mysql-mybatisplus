package com.benjamin;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.HexUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class EncryptDecryptTest {

    private MessageDigest md;



    @Test
    public void case1() {
        // 注册BouncyCastle
        Security.addProvider(new BouncyCastleProvider());

        System.out.println("-------列出加密服务提供者-----");
        Provider[] pro=Security.getProviders();
        for(Provider p:pro){
            System.out.println("Provider:"+p.getName()+" - version:"+p.getVersion());
            System.out.println(p.getInfo());
        }
        System.out.println("");
        System.out.println("-------列出系统支持的消息摘要算法：");
        for(String s:Security.getAlgorithms("MessageDigest"))
            System.out.println(s);

        System.out.println("-------列出系统支持的生成公钥和私钥对的算法：");
        for(String s:Security.getAlgorithms("KeyPairGenerator"))
            System.out.println(s);
    }



    /**
     * MD5 加密
     */
    @Test
    public void md5() {
        // 按名称正常调用
        try {
            md = MessageDigest.getInstance("MD5");
            md.update("HelloWorld".getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] result = md.digest();
        System.out.println(new BigInteger(1, result).toString(16));
        System.out.println(HexUtils.toHexString(result));
    }

    /**
     * SHA-256 加密
     */
    @Test
    public void sha256() {
        // 按名称正常调用
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update("china".getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] result = md.digest();
        System.out.println(new BigInteger(1, result).toString(16));
        System.out.println(HexUtils.toHexString(result));
    }
}
