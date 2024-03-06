package com.benjamin.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedissonUtil {

    @Resource
    private RedissonClient redissonClient;



    /**
     * 加锁
     * @param lockKey
     * @return
     */
    public RLock lock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock();
        return lock;
    }

    /**
     * 获取锁
     * @param lockKey
     * @return
     */
    public RLock getLock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        return lock;
    }

    /**
     * 释放锁
     *
     * @param lockKey
     */
    public void unlock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.unlock();
    }

    /**
     * 释放锁
     * @param lock
     */
    public void unlock(RLock lock) {
        lock.unlock();
    }

    /**
     * 此方法是阻塞获取锁的方式，如果当前锁被其他线程持有，则当前线程会一直阻塞等待获取锁，直到获取到锁或者发生超时或中断等情况才会结束等待。该方法获取到锁之后可以保证线程对共享资源的访问是互斥的，
     * 适用于需要确保共享资源只能被一个线程访问的场景。Redisson 的 lock() 方法支持可重入锁和公平锁等特性，
     * 可以更好地满足多线程并发访问的需求。
     *
     * 带超时的锁
     * @param lockKey
     * @param timeout 超时时间   单位：秒
     */
    public RLock lock(String lockKey, int timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, TimeUnit.SECONDS);
        return lock;
    }

    /**
     * 此方法是阻塞获取锁的方式，如果当前锁被其他线程持有，则当前线程会一直阻塞等待获取锁，直到获取到锁或者发生超时或中断等情况才会结束等待。该方法获取到锁之后可以保证线程对共享资源的访问是互斥的，
     * 适用于需要确保共享资源只能被一个线程访问的场景。Redisson 的 lock() 方法支持可重入锁和公平锁等特性，
     * 可以更好地满足多线程并发访问的需求。
     *
     * 带超时的锁
     * @param lockKey
     * @param unit    时间单位
     * @param timeout 超时时间
     */
    public RLock lock(String lockKey, int timeout, TimeUnit unit) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, unit);
        return lock;
    }

    /**
     *  此方法是一种非阻塞获取锁的方式，在尝试获取锁时不会阻塞当前线程，而是立即返回获取锁的结果，如果获取成功则返回 true，
     *  否则返回 false。Redisson 的 tryLock() 方法支持加锁时间限制、等待时间限制以及可重入等特性，
     *  可以更好地控制获取锁的过程和等待时间，避免程序出现长时间无法响应等问题。
     *
     * 尝试获取锁
     * @param lockKey
     * @param waitTime  最多等待时间 单位：秒
     * @param leaseTime 上锁后自动释放锁时间 单位：秒
     * @return
     */
    public boolean tryLock(String lockKey, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    /**
     *  此方法是一种非阻塞获取锁的方式，在尝试获取锁时不会阻塞当前线程，而是立即返回获取锁的结果，如果获取成功则返回 true，
     *  否则返回 false。Redisson 的 tryLock() 方法支持加锁时间限制、等待时间限制以及可重入等特性，
     *  可以更好地控制获取锁的过程和等待时间，避免程序出现长时间无法响应等问题。
     *
     * 尝试获取锁
     * @param lockKey
     * @param unit      时间单位
     * @param waitTime  最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return
     */
    public boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            return false;
        }
    }
}
