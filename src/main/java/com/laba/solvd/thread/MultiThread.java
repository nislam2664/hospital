package com.laba.solvd.thread;

import com.laba.solvd.enums.Gender;
import com.laba.solvd.hospital.patient.Patient;
import com.laba.solvd.hospital.staff.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MultiThread {
    private static final Logger logger = LogManager.getLogger(MultiThread.class.getName());
    private static int syncCount = 0;
    private static int asyncCount = 0;
    public static Thread t1, t2, t3, t4, t5, t6, t7;

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService threadPool = Executors.newFixedThreadPool(7);

        // OBJECT CREATIONS
        Doctor d1 = new Doctor("Alejandro Saab", LocalDate.parse("1985-07-14"), Gender.MALE, LocalDate.parse("2000-10-31"), 40);
        Patient p1 = new Patient("Mary Jane", LocalDate.parse("1997-09-08"), Gender.FEMALE);
        Doctor d2 = new Doctor("Skyler White", LocalDate.parse("1990-08-19"), Gender.FEMALE, LocalDate.parse("2000-10-31"), 25);
        Patient p2 = new Patient("Sean Chiplock", LocalDate.parse("1996-05-10"), Gender.MALE);

        // THREAD CREATIONS
        t1 = new Thread(d1, "t1 - doctor1");
        t2 = new Thread(p1, "t2 - patient1");
        t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("Thread started ::: " + Thread.currentThread().getName());
                IntStream.range(0, 10000).forEach(i -> {
                    asyncCount++;
                    syncCount();
                });

                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("Thread ended ::: " + Thread.currentThread().getName());
            }
        }, "t3 - count1");
        t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("Thread started::: " + Thread.currentThread().getName());
                IntStream.range(0, 10000).forEach(i -> {
                    asyncCount++;
                    syncCount();
                });

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("Thread ended::: " + Thread.currentThread().getName());
            }
        }, "t4 - count2");
        t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("Thread started::: " + Thread.currentThread().getName());
                IntStream.range(0, 10000).forEach(i -> {
                    asyncCount++;
                    syncCount();
                });

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("Thread ended::: " + Thread.currentThread().getName());
            }
        }, "t5 - count3");
        t6 = new Thread(d2, "t6 - doctor2");
        t7 = new Thread(p2, "t7 - patient2");

        // COMPLETABLE FUTURES
        CompletableFuture<Void> d1Future = CompletableFuture.runAsync(() -> {
            Thread.currentThread().setName("d1Future");
            logger.info("Thread started ::: " + Thread.currentThread().getName());
            System.out.println("Doctor " + d1.getContact().getName() + " is currently seeing a patient...");
            Stream.generate(d1::getIfBusy).filter(busy -> !busy).findFirst().ifPresent(busy -> {
                System.out.println("Doctor " + d1.getContact().getName() + " is free to see the next patient...");
                p1.setIfSeen(true);
                if (d1.getIfBusy())
                    System.out.println("Doctor " + d1.getContact().getName() + " is currently seeing " + p1.getContact().getName() + "...");
            });
            logger.info("Thread ended ::: " + Thread.currentThread().getName());
        });
        CompletableFuture<Void> d2Future = CompletableFuture.runAsync(() -> {
            Thread.currentThread().setName("d2Future");
            logger.info("Thread started ::: " + Thread.currentThread().getName());
            System.out.println("Doctor " + d2.getContact().getName() + " is currently seeing a patient...");
            Stream.generate(d2::getIfBusy).filter(busy -> !busy).findFirst().ifPresent(busy -> {
                System.out.println("Doctor " + d2.getContact().getName() + " is free to see the next patient...");
                p2.setIfSeen(true);
                if (d2.getIfBusy())
                    System.out.println("Doctor " + d2.getContact().getName() + " is currently seeing " + p2.getContact().getName() + "...");
            });
            logger.info("Thread ended ::: " + Thread.currentThread().getName());
        });
        CompletableFuture<Void> p1Future = CompletableFuture.runAsync(() -> {
            Thread.currentThread().setName("p1Future");
            logger.info("Thread started ::: " + Thread.currentThread().getName());
            System.out.println(p1.getContact().getName() + " is waiting to see a doctor...");
            Stream.generate(p1::getIfSeen).filter(seen -> seen == d1.getIfBusy()).findFirst().ifPresent(seen -> {
                d1.setIfBusy(true);
                System.out.println(p1.getContact().getName() + " is going to see " + d1.getContact().getName());
            });
            logger.info("Thread ended ::: " + Thread.currentThread().getName());
        });
        CompletableFuture<Void> p2Future = CompletableFuture.runAsync(() -> {
            Thread.currentThread().setName("p1Future");
            logger.info("Thread started ::: " + Thread.currentThread().getName());
            System.out.println(p2.getContact().getName() + " is waiting to see a doctor...");
            Stream.generate(p2::getIfSeen).filter(seen -> seen == d2.getIfBusy()).findFirst().ifPresent(seen -> {
                d1.setIfBusy(true);
                System.out.println(p2.getContact().getName() + " is going to see " + d2.getContact().getName());
            });
            logger.info("Thread ended ::: " + Thread.currentThread().getName());
        });

        // EXECUTOR THREAD POOL
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                connectionPool.removeConnection();
                t1.start();
                connectionPool.addConnection(t1);
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                connectionPool.removeConnection();
                t2.start();
                connectionPool.addConnection(t2);
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                connectionPool.removeConnection();
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t3.start();
                connectionPool.addConnection(t3);
                t4.start();
                connectionPool.addConnection(t4);
                t5.start();
                connectionPool.addConnection(t5);
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                connectionPool.removeConnection();
                t6.start();
                connectionPool.addConnection(t6);
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                connectionPool.removeConnection();
                t7.start();
                connectionPool.addConnection(t7);
            }
        });

        // End all active threads before shutting down and exiting main thread
        CompletableFuture.allOf(d1Future, p1Future, d2Future, p2Future).join();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAsynchronous count :: " + asyncCount);
        System.out.println("Synchronous count :: " + syncCount + "\n");
        logger.info("All threads are dead, exiting main thread");

        threadPool.shutdown();
    }

    public static synchronized void syncCount() {
        syncCount++;
    }
}
