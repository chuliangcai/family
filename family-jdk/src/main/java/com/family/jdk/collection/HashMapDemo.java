package com.family.jdk.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("111", "ddd");
        map1.put("222", "dddd");
        try {
            map1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
