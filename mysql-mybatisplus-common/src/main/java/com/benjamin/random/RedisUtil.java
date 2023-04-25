package com.benjamin.random;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 参考链接：https://huaweicloud.csdn.net/637ee756df016f70ae4c9233.html?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2~default~BlogCommendFromBaidu~activity-2-124926230-blog-90640057.235^v29^pc_relevant_default_base3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2~default~BlogCommendFromBaidu~activity-2-124926230-blog-90640057.235^v29^pc_relevant_default_base3&utm_relevant_index=3
 * */
@Slf4j
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * lua 脚本
     */
    public static final String SETNX_SCRIPT = "return redis.call('setnx', KEYS[1], ARGV[1])";



    /**
     * redis实现分布式锁
     * @param key
     * @return
     */
    public boolean setNx(String key,int time) {
        // 自定义脚本
        DefaultRedisScript<List> script = new DefaultRedisScript<>(SETNX_SCRIPT, List.class);
        // 执行脚本,传入参数,由于value没啥用,这里随便写死的"1"
        List<Long> rst = redisTemplate.execute(script, Collections.singletonList(key), "1");
        // 返回1,表示设置成功,拿到锁
        if(rst.get(0) == 1){
            log.info(key+"成功拿到锁");
            //设置过期时间
            expire(key,time);
            log.info(key+"已成功设置过期时间:"+time +" 秒");
            return true;
        }else{
            long expire = getExpire(key);
            log.info(key+"未拿到到锁,还有"+expire+"释放");
            return false;
        }
    }

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public void expire(String key, long time) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(key));
            }
        }
    }
}
