package com.laba.solvd.thread;

import com.laba.solvd.hospital.staff.Nurse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class RunnableThread implements Runnable {
    private static final Logger logger = LogManager.getLogger(RunnableThread.class.getName());

    private int threadNumber = 0;

    public RunnableThread() {
        logger.debug("RunnableThread object instantiated");
        logger.warn("RunnableThread object contains no information");
    }

    public RunnableThread(int threadNumber) {
        logger.debug("RunnableThread object instantiated");
        this.threadNumber = threadNumber;
        logger.info("RunnableThread object created");
    }

    @Override
    public void run() {
        logger.info("RunnableThread thread has started running...");
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
