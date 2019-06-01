package com.bogdan.kolomiiets.tasks.Task_9_Threads.Barbershop;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Barbershop{
    private Queue<Thread> queue;

    public Barbershop(int maxCountOfPeopleInQueue) {
        queue = new LinkedBlockingQueue<>(maxCountOfPeopleInQueue);
    }

    public void startCutting(){
        Thread cuttingThread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                    if (queue.peek() == null) {
                        System.out.println("Queue is empty. Barber goes to sleep");
                        queue.add(this);
                        try {
                            synchronized (queue) {
                                queue.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if(queue.peek()==Thread.currentThread()){
                        queue.poll();
                    } else {
                        System.out.println("Client with ID: " + queue.peek().getId() + " started to trim");
                        queue.peek().start();
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Client with ID: " + queue.poll().getId() + " trimmed");
                    }
                }
            }
        };
        cuttingThread.start();
    }

    public boolean addClient(Clients<Thread> client) {
        boolean result = queue.offer(client.wantToTrim());
        if (result) {
            synchronized (queue){
                queue.notifyAll();
            }
            System.out.println("Client " + client.wantToTrim().getId() + " added into queue");
        } else {
            System.out.println("Client " + client.wantToTrim().getId() + " not added into queue. Cause: queue is full");
        }
        return result;
    }
}
