package com.benjamin.utils;

import com.benjamin.constant.EncryptionConstant;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroUtil {

    /**
     * 密码加密
     * @param salt
     * @param password
     * @return
     */
    public static String getEncryptionPassword(String salt, String password) {
        // 指定加密方式
        String hashAlgorithmName = EncryptionConstant.SHA_256_HASH_ALGORITHM_NAME;
        // 循环次数
        int hashIterations = EncryptionConstant.HASH_ITERATIONS;
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }
}
