package demo;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.concat;
import static java.util.stream.IntStream.range;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
        final Counter counter = new Counter();
        final ExecutorService pool = Executors.newFixedThreadPool(1_000);

        range(0, 1_000_000).forEach((number) -> pool.execute(counter::increment));

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(counter.getCounter());
        */

        final MyWorker myWorker = new MyWorker();
        myWorker.start();
        System.out.println("worker started...");
        myWorker.setStop();
        System.out.println("main ended...");
    }
}

// JLS: JMM
// Reordering (refactoring) & Visibility
class MyWorker extends Thread {
    private volatile boolean stop;

    @Override
    public void run() {
//        if (!stop) while(true) {
        while (!stop) {
             synchronized (this) {

             }
        }
    }

    public synchronized void setStop() {
        this.stop = true;
    }
}


class Counter {
    private int counter;
    private AtomicInteger atomicCounter = new AtomicInteger(); // AtomicXXX (CAS)

    private Object monitor = new Object();
    private Lock lock = new ReentrantLock();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void increment() {
        atomicCounter.incrementAndGet();

        var localVar = 0;
        localVar++;

        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }

        synchronized(monitor) { //alternative
            counter++;
            //throw new RuntimeException();
            //return
        }
        //1. -<
        //2. mutate
        //3. ->
    }

    public void decrement() {
        synchronized (monitor) {
            counter--;
        }
    }

    public int getCounter() {
        return counter;
    }
}

class Saver {
    private BufferedWriter output;

    public void save(String message) throws IOException {
        output.write(message);
    }
}

class MyService {
    private Object monitor = new Object();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

//    private Collection<String> data = Collections.synchronizedCollection(new ArrayList<>()); // 2 уровня проблем: операции + fail-fast iterator!!!
    private Collection<String> data = new ArrayList<>(); // 2 уровня проблем: операции + fail-fast iterator!!!

//    public void doSum() {
//        synchronized (monitor) {
//            for (String current : data) {
//
//            }
//        }
//    }
//
//    public void doAdd() {
//        synchronized (monitor) {
//            data.add(null);
//        }
//    }

    public void doSum() {
        try {
            rwLock.readLock().lock();
            for (String current : data) {
                //5
            }
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void doAdd() {
        try {
            rwLock.writeLock().lock();
            data.add(null); // java.util.concurrent -> Concurrent Collection
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}