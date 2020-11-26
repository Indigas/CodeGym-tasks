package com.codegym.task.task38.task3812;

/* 
Processing annotations

*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if(!c.isAnnotationPresent(PrepareMyTest.class))
            return false;

        PrepareMyTest anot = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

        for(String s : anot.fullyQualifiedNames())
            System.out.println(s);

        return true;
    }

    public static boolean printValues(Class c) {
        if(!c.isAnnotationPresent(PrepareMyTest.class))
            return false;

        PrepareMyTest anot = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

        for(Class clazz : anot.value())
            System.out.println(clazz.getSimpleName());

        return true;
    }
}
