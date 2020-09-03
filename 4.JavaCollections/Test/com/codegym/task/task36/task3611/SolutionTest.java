package com.codegym.task.task36.task3611;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Solution sol;

    @BeforeAll
    static void init(){
        sol = new Solution();
        try {
            Method mt = sol.getClass().getDeclaredMethod("generateRelationships");
            mt.setAccessible(true);
            Field ab = sol.getClass().getDeclaredField("humanRelationships");
            ab.setAccessible(true);
            ab.set(sol, mt.invoke(sol));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void getAllFriendsAndPotentialFriends() {
        boolean matches = true;

        Integer[] friends = {0,1,3,2,5,7};
        Arrays.sort(friends);

        Integer[] fromMethod = sol.getAllFriendsAndPotentialFriends(4,2).toArray(new Integer[0]);

        Arrays.stream(friends).forEach(System.out::print);

        System.out.println();

        Arrays.stream(fromMethod).forEach(System.out::print);

        assertArrayEquals(friends, fromMethod);


    }
}