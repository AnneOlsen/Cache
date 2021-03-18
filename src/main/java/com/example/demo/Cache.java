package com.example.demo;

import java.util.HashMap;

public class Cache {


    private HashMap<String, String> cacheData = new HashMap<>();

    public String get(String key) {
        return cacheData.get(key);
    }

    public String set(String key, String value){
        return cacheData.put(key, value);
    }

    public Boolean has(String key){
        return cacheData.containsKey(key);
    }

    public void delete(String key){
        cacheData.remove(key);
    }
}
