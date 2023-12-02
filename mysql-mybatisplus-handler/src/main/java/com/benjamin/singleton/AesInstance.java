package com.benjamin.singleton;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.benjamin.constant.Constants;

public class AesInstance {

    // 必须有volatile修饰（防止指令重排序）
    private volatile static SymmetricCrypto AesInstance;

    // 构造函数必须私有（防止外部通过构造方法创建对象）
    private AesInstance() {

    }

    public static SymmetricCrypto getInstance() {
        // 第一个判空（如果是空，就不必再进入同步代码块了，提升效率）
        if (AesInstance == null) {
            // 这里加锁，是为了防止多线程的情况下出现实例化多个对象的情况
            synchronized (AesInstance.class) {
                // 第二个判空（如果是空，就实例化对象）
                if (AesInstance == null)
                    // 新建实例
                    AesInstance = new SymmetricCrypto(SymmetricAlgorithm.AES, Constants.AES_KEY.getBytes());
            }
        }
        return AesInstance;
    }
}
