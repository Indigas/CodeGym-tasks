package com.codegym.task.task33.task3310.strategy;

import com.codegym.task.task33.task3310.Helper;
import com.codegym.task.task33.task3310.Shortener;
import com.codegym.task.task33.task3310.Solution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapStorageStrategyTest {

    private static StorageStrategy storageStrategy;
    private static Shortener shortener;
    private static Set<String> test=new HashSet<>();

    @BeforeAll
    public static void init(){
        storageStrategy = new OurHashMapStorageStrategy();
        shortener = new Shortener(storageStrategy);
        for(int a=0; a<100;a++)
        test.add(Helper.generateRandomString());
    }

    @Test
    public void testOurMap(){
        Set<Long> testIds = Solution.getIds(shortener, test);
        Set<String> testString = Solution.getStrings(shortener, testIds);

        assertTrue(testIds.size() == testString.size());
    }

}