package com.family.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
    }

    public static class LRUCache extends LinkedHashMap<Integer,Integer>{
        //        private final Map<Integer, Integer> map;
        private static final long serialVersionUID = 1L;
        private int cap;

        public LRUCache(int cap) {
            //            map = new LinkedHashMap<>(cap, 0.75f, true);
            super(cap,0.75f,true);
            this.cap= cap;
        }

        @Override
        public Integer get(Object key) {
             Integer value = super.get(key);
             return value==null?-1:value;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > cap;
        }

        //        public void put(int key, int value) {
        //            map.put(key, value
    }
}
