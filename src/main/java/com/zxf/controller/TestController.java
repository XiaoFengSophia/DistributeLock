package com.zxf.controller;


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Redisson redisson;

    @GetMapping("/getStock")
    public String getStock() {
        String lockKey = "lockKey_stock";
//        String threadId = String.valueOf(Thread.currentThread().getId());
        RLock redissonLock = redisson.getLock(lockKey);
        try {
            //setIfAbsent 相当于setnx(key, vlue),只有在key不存在时设置key的值，key存在时返回false
            /*Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "lockKey_stock");
            stringRedisTemplate.expire(lockKey, 10, TimeUnit.SECONDS);*/
            // 在添加锁的同时设置过期时间
//            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, threadId, 10, TimeUnit.SECONDS);
//            if (!result) {
//                return "error";
//            }
            redissonLock.lock(10, TimeUnit.SECONDS);
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存：" + realStock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } finally {
            // 释放锁,解决锁失效问题
            redissonLock.unlock();
//            if (threadId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
//                stringRedisTemplate.delete(lockKey);
//            }
        }
        return "操作成功！";
    }

}
