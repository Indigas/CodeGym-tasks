package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.FileStorageStrategy;
import com.codegym.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        return strings.stream().map(shortener::getId).collect(Collectors.toSet());
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        return keys.stream().map(shortener::getString).collect(Collectors.toSet());
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println(strategy.getClass().getSimpleName());

        Set<String> test = new HashSet<>();

        for(int a=0; a<elementsNumber; a++){
            test.add(Helper.generateRandomString());
        }

        Shortener sh = new Shortener(strategy);

        // zacat pocitat cas ms
        Date start = new Date();
        Set<Long> testId = getIds(sh, test);
        Date stop = new Date();
        // ukoncit pocitat cas ms
        long inMs = stop.getTime() - start.getTime();
        // ako dlho trvalo

        System.out.println("Method getIds time run: " + inMs);

        //////////////////////
        Date start1 = new Date();
        Set<String> testStrings = getStrings(sh, testId);
        Date stop1 = new Date();
        inMs = stop1.getTime() - start1.getTime();

        System.out.println("Method getStrings time run: " + inMs);


        if(test.containsAll(testStrings) && testStrings.containsAll(test))
            System.out.println("The test passed.");
        else
            System.out.println("The test failed.");
    }

    public static void main(String[] args) {
       /* testStrategy(new HashMapStorageStrategy(), 10000L);
        testStrategy(new OurHashMapStorageStrategy(), 10000L);*/
        testStrategy(new FileStorageStrategy(), 10L);
    }
}
