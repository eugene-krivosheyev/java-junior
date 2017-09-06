package com.acme.edu.concurrency;

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
    }
}

class Counter {
    private int state = 0;

    /**
     * Data Race
     */
    public void increment() {
        synchronized (this) {
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