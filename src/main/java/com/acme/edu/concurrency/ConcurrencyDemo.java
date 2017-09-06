package com.acme.edu.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            int internalCounter = 0;

            while (internalCounter++ < 1_000_000) {
                counter.increment();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            int internalCounter = 0;

            while (internalCounter++ < 1_000_000) {
                counter.increment();
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(counter.getState());

        Lock lock = new ReentrantLock();
        lock.lock();
        lock.tryLock();
    }
}

class Counter {
    private int state = 0;
    private Object monitor = new Object();

    /**
     * Data Race
     */
    public void increment() {
        synchronized (monitor) {
            state++;
        }
        //-> state
        //state = state + 1
        //<- state
    }

    public int getState() {
        return state;
    }

    public static void printSmth() {
        synchronized (Counter.class) {

        }
    }
}

