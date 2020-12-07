package com.codegym.task.task28.task2806;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* 
Introducing Executors

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // Add your code here
        ExecutorService exe = Executors.newFixedThreadPool(5);

        for(int a=1;a<11;a++){
            final int b = a;
            exe.submit(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(b);
                }
            });
        }

        exe.shutdown();
        exe.awaitTermination(5, TimeUnit.SECONDS);

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
