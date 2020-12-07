package com.codegym.task.task28.task2807;

import java.util.concurrent.*;

/* 
Introducing ThreadPoolExecutor

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // Add your code here
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();

        for(int a = 1;a<11;a++){
            final int b = a;
            linkedBlockingQueue.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(b);
                }
            });
        }

        ThreadPoolExecutor es = new ThreadPoolExecutor(3,5,1000,TimeUnit.MILLISECONDS, linkedBlockingQueue);
        es.prestartAllCoreThreads();
        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
