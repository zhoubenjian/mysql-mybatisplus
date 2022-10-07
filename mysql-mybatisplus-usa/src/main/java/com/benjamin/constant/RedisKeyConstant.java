package com.benjamin.constant;

import java.text.MessageFormat;

public abstract class RedisKeyConstant {

    // All State RedisKey
    private static final String ALL_STATE_INFO_KEY = "allStateInfo:{0}";

    // Exist Party RedisKey
    private static final String EXIST_PARTY_INFO_KEY = "existPartyInfo:{0}";

    // All President RedisKey
    private static final String ALL_PRESIDENT_INFO_KEY = "allPresidentInfo:{0}";



    /**
     * get all state info
     * @param key
     * @return
     */
    public static String getAllStateInfo(String key) {
        return MessageFormat.format(ALL_STATE_INFO_KEY, key);
    }

    /**
     * get exist party info
     * @param key
     * @return
     */
    public static String getExistPartyInfo(String key) {
        return MessageFormat.format(EXIST_PARTY_INFO_KEY, key);
    }

    /**
     * get all president info
     * @param key
     * @return
     */
    public static String getAllPresidentInfo(String key) {
        return MessageFormat.format(ALL_PRESIDENT_INFO_KEY, key);
    }
}
