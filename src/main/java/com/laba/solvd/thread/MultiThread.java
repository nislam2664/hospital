package com.laba.solvd.thread;

public class MultiThread {
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

        Thread threadA = new Thread(new RunnableThread(1));
        MyThread threadB = new MyThread(2);

        threadA.start();
        threadB.start();

    }
}
