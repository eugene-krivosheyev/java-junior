package concurrencydemo;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class Counter {
    private int value;
    private Collection history; //Collections.synchronizedCollection(?)

    /**
     * Amdal Law: P = 1/%sync
     * -fairness-
     */
    public void increment() {
        synchronized(this) {
            value++;
        }
    }

}