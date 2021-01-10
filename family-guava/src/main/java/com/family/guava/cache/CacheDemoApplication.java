package com.family.guava.cache;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheDemoApplication {

    public static void main(String[] args) throws Exception {
        LoadingCache<String, Object> graphs = CacheBuilder.newBuilder()
                .refreshAfterWrite(10, TimeUnit.SECONDS).build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String s) throws Exception {
                        System.out.println("reload:" + s);
                        return new Object();
                    }

                    @Override
                    public Map<String, Object> loadAll(Iterable<? extends String> keys) throws Exception {
                        return super.loadAll(keys);
                    }
                });
        graphs.get("abc");
        System.out.println("get abc");
        Thread.sleep(1000*20);
        graphs.get("abc");
        System.out.println("get abc");
    }
}
