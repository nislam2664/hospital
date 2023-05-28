package com.laba.solvd.thread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConnectionPool {
    private final int POOL_SIZE = 5;
    private final BlockingQueue<Thread> connectionPool;
    private static ConnectionPool instance;

    private ConnectionPool() {
        connectionPool = new ArrayBlockingQueue<>(POOL_SIZE);
        IntStream.range(0, 5).forEach(i -> addConnection(new Thread()));
    }

    public static synchronized ConnectionPool getInstance() {
        // lazy initialization
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }

    public Thread top() {
        return connectionPool.peek();
    }

    public synchronized void addConnection(Thread thread) {
        boolean offered = connectionPool.offer(thread);
    }

    public synchronized void removeConnection() {
        try {
            assert connectionPool.peek() != null;
            if (!connectionPool.peek().isAlive())
                connectionPool.take();
        } catch (InterruptedException e) {
            System.out.println("Current thread has been interrupted!");
        }
    }
}
