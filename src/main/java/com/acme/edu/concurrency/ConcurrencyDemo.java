package com.acme.edu.concurrency;

import java.util.ArrayList;
import java.util.List;
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


class BlockingQueue<T> {
    private List<T> queue = new ArrayList<>(10);

    public void add(T element) {
        synchronized (queue) {
            queue.add(element);
            queue.notifyAll();
        }
    }

    public T get() {
        synchronized (queue) {
            try {
                while (queue.isEmpty()) {
                    queue.wait();
                }
            } catch (InterruptedException e) {
                return null;
            }
            return queue.remove(0);
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> q = new BlockingQueue<>();

        new Thread(() -> {
            try {
                Thread.sleep(5_000);
                q.add("qqq");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(q.get());
    }
}

