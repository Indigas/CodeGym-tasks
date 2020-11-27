package com.codegym.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //write your code here
        int velkost = 0;

        Iterator<Entry<K, List<V>>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Entry<K, List<V>> entry = it.next();
            List<V> list = entry.getValue();
            if(list!=null)
                velkost += entry.getValue().size();
        }

        return velkost;
    }

    @Override
    public V put(K key, V value) {
        //write your code here
        List<V> list = new LinkedList<>();
        V lastOne=null;

        if(map.containsKey(key)){
            list = map.get(key) != null ? map.get(key) : list;

            if(list.size()==repeatCount)
                list.remove(0);

            for(V a : list){
                lastOne = a;
            }

            list.add(value);

            return lastOne;
        }

        list.add(value);
        map.put(key, list);
        return null;
    }

    @Override
    public V remove(Object key) {
        //write your code here
        if(!map.containsKey(key))
            return null;

        List<V> list = map.get(key);
        V elem=list.remove(0);

        if(list.isEmpty())
            map.remove(key);

        return elem;
    }

    @Override
    public Set<K> keySet() {
        //write your code here
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //write your code here
        List<V> list = new ArrayList<>();
        for (Entry<K, List<V>> entry : map.entrySet()) {
            list.addAll(entry.getValue());
        }

        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //write your code here
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //write your code here
        for(Entry<K, List<V>> entry : map.entrySet()){
            if(entry.getValue().contains(value))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}