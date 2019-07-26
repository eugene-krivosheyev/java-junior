package com.acme.edu.threadsdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrencyDemo {
    public static void main(String[] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(40);
        final Counter counter = new Counter();
        for (int i = 0; i < 100_000; i++) {
            pool.submit(counter::increment);
        }
        pool.shutdown();
        System.out.println(counter.getCount());
    }
}

class Counter {
    private int count;
    private Lock l = new ReentrantLock(); //ReadWrite

    public void increment() {
        l.tryLock();
        l.lock();
        synchronized (this) {
            count++; //<-, ?, ->
        }
        l.unlock(); //finally
    }

    public int getCount() {
        return count;
    }
}


class ThreadStopDemo {
    public static void main(String[] args) throws InterruptedException {
        final MyWorker myWorker = new MyWorker();
        myWorker.start();

        Thread.sleep(1_000);
        myWorker.setStop();

    }
}

class MyWorker extends Thread {
    private volatile boolean isStop = false;

    @Override
    public void run() {
        while (!isStop) {

        }
    }

    public void setStop() {
        isStop = true;
    }
}