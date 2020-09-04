package com.codegym.task.task33.task3310.strategy;

import java.util.*;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        Set<Map.Entry<Long, String>> mp = data.entrySet();
        Optional<Map.Entry<Long, String>> res = mp.stream().filter(test -> test.getValue().equals(value)).findFirst();

        return res.map(Map.Entry::getKey).orElse(null);

    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
