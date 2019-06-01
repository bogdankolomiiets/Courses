package com.bogdan.kolomiiets.tasks.Task_9_Threads.Barbershop;

public class Main {
    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop(5);
        barbershop.startCutting();

        Thread clientThread = new Thread(() -> {
            while (true){
                barbershop.addClient(new Client());
                try {
                    Thread.sleep(4500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        clientThread.start();
    }
}
