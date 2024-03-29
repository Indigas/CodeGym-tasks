package com.codegym.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    @Override
    public void run() {
        try {
            while(!thread.isInterrupted()) {
                System.out.println(thread.getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException ignored){}
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
