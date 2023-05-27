package com.laba.solvd.thread;

import com.laba.solvd.hospital.staff.Nurse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class MyThread extends Thread {
    private static final Logger logger = LogManager.getLogger(MyThread.class.getName());

    private int threadNumber = 0;

    public MyThread() {
        super();
        logger.debug("MyThread object instantiated");
        logger.warn("MyThread object contains no information");
    }

    public MyThread(Runnable target, String name, int threadNumber) {
        super(target, name);
        logger.debug("MyThread object instantiated");
        this.threadNumber = threadNumber;
        logger.info("MyThread object created");
    }

    @Override
    public void run() {
        logger.info("MyThread thread has started running...");
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
            System.out.println("Hello from Thread class " + this.getId());
        else
            System.out.println("Hello from Thread class " + threadNumber);
    }
}
