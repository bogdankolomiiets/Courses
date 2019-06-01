package com.bogdan.kolomiiets.tasks.Task_9_Threads;

public class Task9_2 {
    private int i = 0;
    private int maxValue = 1_000_000;
    private Object lock = new Object();

    public static void main(String[] args) {
        Task9_2 task9_2 = new Task9_2();
        task9_2.initThreads();
    }

    public void initThreads(){ ;
        Runnable runnableCounter = () -> {
            while (i < maxValue) {
                i++;
                try {
                    synchronized (lock) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnableCounter, "Counter");

        Runnable runnablePrinter = () -> {
            while (i < maxValue) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                synchronized (lock) {
                    lock.notifyAll();
                }
            }
        };
        Thread thread2 = new Thread(runnablePrinter, "Printer");

        thread1.start();
        thread2.start();
    }
}
