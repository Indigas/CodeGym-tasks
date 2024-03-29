package com.codegym.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<T> extends AbstractSet<T> implements Serializable, Cloneable, Set<T> {

    private static final Object PRESENT = new Object();
    private transient HashMap<T, Object> map;
    private int mapCapacity;
    private float loadFactor;
    private Set<T> forSerial;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends T > collection){
        this.map = new HashMap<>(Math.max(16,(int)Math.ceil(collection.size()/0.75f)));

        collection.forEach(object -> this.map.put(object, PRESENT));
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
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

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object o;
        
        try {
             o = super.clone();
            //((AmigoSet<T>) o).map = (HashMap<T, Object>)map.clone();
            Object mp = map.clone();
        } catch (Exception e){
            throw new InternalError();
        }

        return o;
    }

    private void writeObject(ObjectOutputStream oos){
        forSerial = new HashSet<>();
        forSerial.addAll(map.keySet());
        try {
            loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
            mapCapacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        } catch (Exception e){}

        try {
            oos.defaultWriteObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois){
        try {
            ois.defaultReadObject();

            map = new HashMap<>(mapCapacity, loadFactor);

            forSerial.forEach(key -> map.put(key, PRESENT));


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
}
