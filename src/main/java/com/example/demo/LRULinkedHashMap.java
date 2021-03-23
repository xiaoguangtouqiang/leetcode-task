package com.example.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap extends LinkedHashMap<String, String> {

    private int maxSize;

    public LRULinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
        this.maxSize = initialCapacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        if (size() > maxSize) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LRULinkedHashMap ss = new LRULinkedHashMap(5, 0.75f);
        ss.put("1", "3");
        ss.put("2", "4");
        ss.put("3", "6");
        ss.put("4", "1");
        ss.put("5", "5");

        for(Map.Entry e: ss.entrySet()) {
            System.out.println(e.getKey());
        }
        System.out.println("---------------");

        ss.get("1");

        for(Map.Entry e: ss.entrySet()) {
            System.out.println(e.getKey());
        }
        System.out.println("---------------");
        ss.put("7", "10");

        for(Map.Entry e: ss.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
