package com.acme.parallelismdemo;

import java.util.concurrent.*;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;

public class ThreadsDemo {
    public static void main(String[] args) {
        //Parallelism:
        /*
        Thread remote = new Thread() {
            @Override
            public void run() {
                while (!interrupted()) {
                    currentThread().getName(); //Thread-2
                    System.out.println("thread");

                    try {
                        Thread.sleep(5_000);
                        //myObject.someOperation(); //wait
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        remote.start();
        remote.stop();
        remote.suspend(); remote.resume();
        remote.setDaemon(true);
        remote.setPriority(Thread.MAX_PRIORITY);
        remote.interrupt();
        remote.isInterrupted();

        Thread t2 = new Thread(() -> {
            //ksjghfkgjhk
        });
        t2.start();
        */

        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.submit(() -> System.out.println("Heelloooo1"));
        pool.submit(() -> System.out.println("Heelloooo2"));
        pool.submit(() -> System.out.println("Heelloooo3"));
        pool.submit(() -> System.out.println("Heelloooo4"));

        Future<Integer> futureResult = pool.submit(() -> {
            Thread.sleep(5_000);
            return 2 + 2;
        });

        futureResult.isDone(); //polling
        try {
            System.out.println(futureResult.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }

        pool.shutdown();
        //Concurrency:
    }
}
