package com.family.guava.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterDemo {
    private static final RateLimiter rateLimiter = RateLimiter.create(1);

    public static void main(String[] args) {
        System.out.println(rateLimiter.tryAcquire(100));
        System.out.println(rateLimiter.tryAcquire(1));
    }

   public static class MyRateLimiter{
        private int permitsPerSecond;
        private long createTime;
        public boolean tryAcquire(int n){
            // 比如1秒中生产5个，也就是200毫秒生产一个
            // 令牌桶可以理解为一个容量固定的桶, 放多了就没有了
            // 1-200 200-400 400-600 600-800 800-1000 1000-1200
         //5 // 放1     放1     放1     放1     放1        放1     放1
             //  +1    +1       +1     +1      +1        +1     +1    +1    +1
            // 将每200毫秒消耗2个 那么什么时候用完
            // -2      -2       -2     -2      -2        -2     -2    -2    -2
        //剩余   4      3        2      1       0         不够    0     不够   0 .....
            return false;
            //任意时刻能否获取令牌实际只需要看桶内还有没有够数的令牌即可
            //那么怎么表示桶理的剩余令牌呢
            //其实可记录下上次获取令牌的时间，已经上次桶里面剩余的令牌数即可
            //那么本次时间减去上次时间x生产令牌的速率，就是桶里面剩余的令牌
            //上次获取令牌的时间好弄, 那上次剩余的令牌怎么算呢
            //如果从最开始算起,每获取锁都记录一次，那么桶里面的令牌还是可以算出来的。
            //第一次的剩余令牌数是5，第一次的令牌获取时间可以认为是创建时间

            //  那第二次是否可以获取令牌 = (本次时间-上次时间)x生产速率 + 上次剩余数量 > 本次消耗数量即可
            // 如果满足, 更新下剩余令牌数量和最后后去令牌时间

            // 等等,上面这种情况看上去没有问题。加入生产令牌的速度很快。桶都装不下上面不久gg了
            //看来这个算法还是有问题
            //有办法,我把  (本次时间-上次时间)x生产速率 + 上次剩余数量 的结果和桶的容量取一个最大值，如果大于桶的容量了，那么可以任务剩余数量就按桶的容量算即可
            //然后减去消耗的数量，更新信息。
            //你认为我的算法有问题吗，欢迎指正
        }
   }
}
