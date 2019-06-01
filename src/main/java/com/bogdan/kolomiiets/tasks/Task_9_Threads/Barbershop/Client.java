package com.bogdan.kolomiiets.tasks.Task_9_Threads.Barbershop;

public class Client<T> implements Clients<T> {
    private Thread threadToTrim;

    public Client(){
        wantToTrim();
    }

    public Thread wantToTrim() {
        if (threadToTrim == null) {
            threadToTrim = new Thread(() -> {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        return threadToTrim;
    }
}
