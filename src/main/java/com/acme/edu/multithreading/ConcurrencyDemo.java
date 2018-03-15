package com.acme.edu.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int threads = 0; threads < 1_000; threads++) {
            pool.submit(() -> incrementForCounter(counter));
        }

        System.out.println(counter.getCounter());

        //BusinesService.doComplexOperation() {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        synchronized (counter1) {
            synchronized (counter2) {
                counter1.increment();
                counter2.increment();
            }
        }

        //BusinesService.doComplexOperation(list, coll2) {
//        synchronized (this) {
            List list = new ArrayList();
        synchronized (list) {
//            synchronized (coll2) {
//
//            }
        }

//        }
//        JMM, wait()/notify()
    }

    private static void incrementForCounter(Counter counter) {
        for (int i = 0; i < 10_000; i++) {
            counter.increment();
        }
    }
}

class Counter {
    private int counter;
    private Object monitor = new Object();

    /**
     * Critical section
     * Amdal Law: Per = 1 / % sync code
     */
    public void increment() {
        int i;
        synchronized (monitor) {
            counter++;
            //gjdhkgjdhgkjfh
        }

        Lock monit = new ReentrantLock();
        monit.tryLock();
        monit.lock();
        //dflgjhdfkgjh
        monit.unlock();

        AtomicInteger atomicCounter = new AtomicInteger(); //FIELD!!!!

        /*
        while(!success) { //Lock-free | Optimistic
            atomicCounter.accumulateAndGet(x, ()->); //CAS operations
            //Primitive opertions
        }
        */

        //1. <-
        //2. ++
        //3. ->
    }

    public void mul2 () {
        counter = counter * 2;
    }


    public int getCounter() {
        return counter;

//        BlockingQueue<String> q = new ArrayBlockingQueue(9);
//        String o = q.poll();
        //if (o != null) {

        //}
    }
}

//Visibility & Reordering: JMM -> Happens-before
class MyThread extends Thread {
    private boolean isStoped;

    public synchronized boolean isStopped() {
        return isStoped;
    }

    public synchronized void setStoped(boolean stoped) {
        isStoped = stoped;
    }

    @Override
    public void run() {
//        if (!isStoped) { while (true) {} }
        while (!this.isStopped()) {

        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread.sleep(5_000);

        myThread.setStoped(true);
    }
}
