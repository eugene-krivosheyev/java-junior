package com.acme.edu.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        final Counter sharedData = new Counter();
        final ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100_000; i++) {
            pool.submit(sharedData::increment);
        }

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(sharedData.getCounter());

    }
}

class Counter {
    private int counter;
    private Object monitor = new Object();

    /**
     * Data Race
     */
    public void increment() {
        //...
        synchronized (this.monitor) {
            // <-
            // update
            // ->
            this.counter++;
        }
        //...
    }

    public int getCounter() {
        synchronized (this.monitor) {
            return counter;
        }
    }
}
