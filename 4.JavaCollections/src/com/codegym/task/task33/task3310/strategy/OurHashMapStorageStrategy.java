package com.codegym.task.task33.task3310.strategy;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public class OurHashMapStorageStrategy implements StorageStrategy{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold=(int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    int hash(Long k){
        return k.hashCode();
    }

    int indexFor(int hash, int length){
        return hash & (length)-1;
    }

    Entry getEntry(Long key){
        Optional<Entry> en = Arrays.stream(table).filter(entry -> entry!=null && entry.getKey().equals(key)).findFirst();

        return en.orElse(null);
    }

    void resize(int newCapacity){
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (1 << 30)) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, (1 << 30) + 1);
    }

    void transfer(Entry[] newTable){
       /* newTable = Arrays.copyOf(table, newTable.length);
        this.table = newTable;*/

        int newCapacity = newTable.length;
        for (Entry e : table) {
            while(null != e) {
                Entry next = e.next;
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return Arrays.stream(table).filter(entry -> entry!=null && entry.getKey()!=null).anyMatch(entry -> entry.getKey().equals(key));
    }

    @Override
    public boolean containsValue(String value) {
        return Arrays.stream(table).filter(entry -> entry!=null && entry.getValue()!=null).anyMatch(entry -> entry.getValue().equals(value));
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, indexFor(hash(key),table.length));
    }

    @Override
    public Long getKey(String value) {
        return Arrays.stream(table).filter(entry -> entry!=null && entry.getValue().equals(value)).findFirst().map(Entry::getKey).orElse(null);
    }

    @Override
    public String getValue(Long key) {
        return Arrays.stream(table).filter(entry -> entry!=null && entry.getKey().equals(key)).findFirst().map(Entry::getValue).orElse(null);
    }
}
