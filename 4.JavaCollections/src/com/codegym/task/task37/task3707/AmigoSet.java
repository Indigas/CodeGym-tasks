package com.codegym.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<T> extends AbstractSet<T> implements Serializable, Cloneable, Set<T> {

    private static final Object PRESENT = new Object();
    private transient HashMap<T, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends T > collection){
        this.map = new HashMap<>(Math.max(16,(int)Math.ceil(collection.size()/0.75f)));

        collection.forEach(object -> this.map.put(object, PRESENT));
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
       if(this.map.put((T)o, PRESENT) == null)
           return true;

       return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }
}
