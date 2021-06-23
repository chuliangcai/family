package com.family.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;

public class RedissonDemo {
    public static void main(String[] args) {
        Redisson a=null;
        RRateLimiter rRateLimiter = a.getRateLimiter("aaa");
        rRateLimiter.trySetRate(RateType.OVERALL, 1, 10, RateIntervalUnit.SECONDS);
        if(rRateLimiter.tryAcquire(1)){
            //获取令牌成功
        }
    }
}
