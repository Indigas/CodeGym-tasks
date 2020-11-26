package com.codegym.task.task38.task3810;

public @interface Revision {
    // Write your own code
    int revision();
    String comment() default "";
    Date date();
    Author[] authors() default {};
}