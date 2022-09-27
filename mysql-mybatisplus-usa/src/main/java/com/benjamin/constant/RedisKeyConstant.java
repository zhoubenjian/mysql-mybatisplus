package com.benjamin.constant;

import java.text.MessageFormat;

public abstract class RedisKeyConstant {

    // All State RedisKey
    private static final String ALL_STATE_INFO_KEY = "allStateInfo:{0}";



    /**
     * get all State info
     * @param key
     * @return
     */
    public static String getAllStateInfo(String key) {
        return MessageFormat.format(ALL_STATE_INFO_KEY, key);
    }
}
