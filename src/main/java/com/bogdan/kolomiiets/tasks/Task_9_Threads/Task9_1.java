package com.bogdan.kolomiiets.tasks.Task_9_Threads;

public class Task9_1{
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 10; i >= 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Bomb");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
