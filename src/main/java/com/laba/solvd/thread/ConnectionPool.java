package com.laba.solvd.thread;

import java.util.concurrent.*;

public class ConnectionPool {
    private final int POOL_SIZE = 5;
    private final BlockingQueue<Connect> connectionPool = new LinkedBlockingQueue<>(POOL_SIZE);

    private ConnectionPool() {
        initialize();
    }

    public void initialize() {
        for (int i = 0; i < POOL_SIZE; i++)
            connectionPool.add(createConnection());
    }

    public Connect createConnection() {
        return new Connect();
    }

    public Connect getConnection() throws InterruptedException {
        return connectionPool.take();
    }

    public boolean giveConnection(Connect conn) {
        return connectionPool.offer(conn);
    }
}
