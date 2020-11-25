package com.codegym.task.task33.task3310.strategy;


import java.util.Arrays;
import java.util.Optional;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY=16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000L;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    int hash(Long k){
        return k.hashCode();
    }

    int indexFor(int hash, int length){
        return hash & (length)-1;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public FileStorageStrategy() {
        for(int i = 0; i<table.length; i++)
            table[i] = new FileBucket();
    }


    void resize(int newCapacity){
        FileBucket[] newTable =new FileBucket[newCapacity];

        for(int i = 0; i<table.length;i++)
            newTable[i] = new FileBucket();

        transfer(newTable);

        for(int i = 0; i < table.length; i++)
            table[i].remove();

        table = newTable;
    }

    private void addToFileBucketTable(int hash, Long key, String value, int bucketIndex){
        if(maxBucketSize > bucketSizeLimit){
            resize( 2 * table.length);
            bucketIndex = indexFor(key.hashCode(), table.length);
        }
        createEntry(key, value, bucketIndex);
    }

    private void createEntry(Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex].getEntry();

        table[bucketIndex].putEntry(new Entry(hash(key), key, value, e));
        size++;

        long currentBucketSize =table[bucketIndex].getFileSize();
        if(currentBucketSize > maxBucketSize)
            maxBucketSize =currentBucketSize;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        maxBucketSize = 0;

        for(FileBucket fileBucket : table){
            Entry entry = fileBucket.getEntry();
            while(entry!=null){
                Entry next = entry.next;
                int indexInNewTable = indexFor(entry.getKey().hashCode(), newCapacity);
                entry.next = newTable[indexInNewTable].getEntry();
                entry = next;
            }

            long currentBucketSize = fileBucket.getFileSize();
            if (currentBucketSize > maxBucketSize)
                maxBucketSize = currentBucketSize;
        }
    }

    @Override
    public boolean containsKey(Long key) {
        return Arrays.stream(table).filter(entry -> entry.getEntry()!=null).anyMatch(entry -> entry.getEntry().getKey().equals(key));
    }

    @Override
    public boolean containsValue(String value) {
        return Arrays.stream(table).filter(entry -> entry.getEntry()!=null).anyMatch(entry -> entry.getEntry().getValue().equals(value));
    }

    @Override
    public void put(Long key, String value) {
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        for(Entry e = table[index].getEntry(); e!=null; e = e.next){
            if(key.equals(e.key)){
                e.value = value;
                return;
            }
        }

        addToFileBucketTable(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        /*Optional<FileBucket> o = Arrays.stream(table).filter(t -> t.getEntry().getValue().equals(value)).findFirst();
        return o.map(fileBucket -> fileBucket.getEntry().getKey()).orElse(null);*/

        return Arrays.stream(table).filter(entry -> entry!=null && entry.getEntry()!=null)
                .filter(entry -> entry.getEntry().getValue().equals(value)).findFirst().map(t -> t.getEntry().getKey()).orElse(null);
    }

    @Override
    public String getValue(Long key) {
        /*Optional<FileBucket> o = Arrays.stream(table).filter(t -> t.getEntry().getKey().equals(key)).findFirst();
        return o.map(fileBucket -> fileBucket.getEntry().getValue()).orElse(null);*/

        return Arrays.stream(table)
                .filter(entry -> entry!=null && entry.getEntry()!=null)
                .filter(entry -> entry.getEntry().getKey().equals(key)).findFirst()
                .map(t -> t.getEntry().getValue()).orElse(null);

    }
}
