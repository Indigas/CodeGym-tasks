package com.codegym.task.task33.task3310.tests;

import com.codegym.task.task33.task3310.*;
import static org.junit.jupiter.api.Assertions.*;

import com.codegym.task.task33.task3310.strategy.*;
import org.junit.jupiter.api.Test;

public class FunctionalTest {

    @Test
    void testHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    void testOurHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    void testFileStorageStrategy(){
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    void testHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    void testDualHashBidiMapStorageStrategy(){
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    void testOurHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }



    public void testStorage(Shortener shortener){
        String[] one = {"marek", "patrik", "marek"};
        Long[] ids = new Long[3];

        for(int a = 0; a<3;a++)
            ids[a] = shortener.getId(one[a]);

        assertEquals(one[0], shortener.getString(ids[0]));
        assertEquals(one[1], shortener.getString(ids[1]));
        assertEquals(one[2], shortener.getString(ids[2]));


        assertNotEquals(shortener.getId(one[1]), shortener.getId(one[2]));
        assertNotEquals(shortener.getId(one[1]), shortener.getId(one[0]));

        assertEquals(shortener.getId(one[0]), shortener.getId(one[2]));
    }
}
