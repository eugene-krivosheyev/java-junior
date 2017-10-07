package com.acme.parallelismdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        String monitor = new String();
        Counter count = new Counter(monitor);
        Counter count2 = new Counter(monitor);
        count.increment();
        count2.increment();

        ExecutorService pool = Executors.newFixedThreadPool(1_000);
        for (int counter = 0; counter < 10_000; counter++) {
            pool.submit(count::increment);
        }
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(count.getCounter()); //10_000
    }
}


class Counter {
    private int counter = 0;
    private Object monitor;

    Counter(Object monitor) {
        this.monitor = monitor;
    }


    public void increment() {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        try {
            lock.readLock().lock();

            //kfgjhdfkgjhgkjdkjh
        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
        }
        //heap.counter -> local
        //local = local + 1
        //local -> heap.counter
    }

    public void decrement() {
        synchronized (monitor) {
            /*
            if (counter <= 0) monitor.wait();
                counter--;
                */
        }
    }

    public int getCounter() {
        synchronized (monitor) {
            return counter;
        }
    }
}

//JMM: reordering, visibility
class MyThread extends Thread {
    private boolean isStopped = false;

    public synchronized void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (isStopped) return;
            }
        }
    }
}

class VisibilityDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5_000);
        myThread.setStopped(true);
    }
}