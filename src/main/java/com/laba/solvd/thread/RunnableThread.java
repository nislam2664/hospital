package com.laba.solvd.thread;

import java.util.Random;

public class RunnableThread implements Runnable {
    private int threadNumber = 0;

    public RunnableThread() {

    }

    public RunnableThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        Random rand = new Random();

        for(int i = 0; i < 5; i++) {
            int num = rand.nextInt(5) + 1;
            try {
                message();
                System.out.println(num);
                MyThread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void message() {
        if (threadNumber == 0)
            System.out.println("Hello from Runnable interface");
        else
            System.out.println("Hello from Runnable interface " + threadNumber);
    }
}
