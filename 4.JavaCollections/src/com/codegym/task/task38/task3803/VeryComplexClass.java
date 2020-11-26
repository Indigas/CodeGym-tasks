package com.codegym.task.task38.task3803;

/* 
Runtime exceptions (unchecked exceptions)

*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object x = new Integer(2);
        System.out.println((String)x);
    }

    public void methodThrowsNullPointerException() {
        String a = null;
        a.toUpperCase();
    }

    public static void main(String[] args) {
    }
}