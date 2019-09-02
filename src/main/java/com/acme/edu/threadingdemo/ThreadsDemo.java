package com.acme.edu.threadingdemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        pool.execute(() -> System.out.println("HW1"));
        pool.execute(() -> System.out.println("HW2"));
        pool.execute(() -> System.out.println("HW3"));
        pool.execute(() -> System.out.println("HW4"));

        final Future<Integer> futureInt = pool.submit(() -> {
            return 2 + 2;
        });

//        futureInt.get();
        futureInt.isDone();
        futureInt.cancel(true);

        pool.shutdown();




    }
}