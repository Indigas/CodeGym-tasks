package com.codegym.task.task37.task3708.retrievers;

import com.codegym.task.task37.task3708.cache.LRUCache;
import com.codegym.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache<Long, Object> lruCache;
    private OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage){
        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<Long, Object>(5);
    }

    @Override
    public Object retrieve(long id) {
        Object ab = lruCache.find(id);
        if(ab==null){
            Object bc = originalRetriever.retrieve(id);
            lruCache.set(id, bc);
            return bc;
        } else
            return ab;
    }
}
