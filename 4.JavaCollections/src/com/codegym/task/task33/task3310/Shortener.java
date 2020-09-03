package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.StorageStrategy;

import java.util.HashMap;

public class Shortener {
    private Long lastId=0L;
    private String string;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {
        if(storageStrategy.containsValue(string))
            return storageStrategy.getKey(string);

        this.lastId++;
        storageStrategy.put(this.lastId, string);

        return this.lastId;
    }

    public String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
