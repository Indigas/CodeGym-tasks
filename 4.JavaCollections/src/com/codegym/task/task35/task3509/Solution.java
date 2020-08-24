package com.codegym.task.task35.task3509;

import java.util.*;
import java.util.stream.Collectors;


/* 
Collections & Generics

*/
public class Solution {

    public static void main(String[] args) {
        List<String> b = new ArrayList<>();
        b.add("jano");
        List<Integer> c = new ArrayList<>();
        c.add(2);
        Map a = newHashMap(b, c);
        a.forEach((key, value) -> System.out.println(key.toString() + " " +value.toString()));
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //write your code here
        return new ArrayList(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //write your code here

        return (HashSet)Arrays.stream(elements).collect(Collectors.toSet());
    }

    public static <K, V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //write your code here
        if(keys.size() != values.size())
            throw new IllegalArgumentException("Size of list doesnt match");

        Map<K, V> a = new HashMap();
        for(int b = 0; b<keys.size();b++){
            a.put(keys.get(b), values.get(b));
        }


        return (HashMap)a;
    }
}
