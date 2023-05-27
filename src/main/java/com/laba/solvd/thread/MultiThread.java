package com.laba.solvd.thread;

import com.laba.solvd.hospital.staff.Nurse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiThread {
    private static final Logger logger = LogManager.getLogger(MultiThread.class.getName());

    /*
    Create 2 Threads using Runnable and Thread. done?

    Create Connection Pool. Use collection from java.util.concurrent package.
    Connection class may be mocked. The pool should be threadsafe and lazy initialized.

    Initialize Connection Pool object of size 5. Load Connection Pool using single
    threads and Java Thread Pool (7 threads in total). 5 threads should be able to get
    the connection. 2 Threads should wait for the next available connection. The program
    should wait as well.

    Implement previous point but with interfaces Future and CompletableStage.
    */
    public static void main(String[] args) {

        Thread threadA = new Thread(new RunnableThread(1), "thread1");
        MyThread threadB = new MyThread();

        threadA.start();
        threadB.start();

    }
}
