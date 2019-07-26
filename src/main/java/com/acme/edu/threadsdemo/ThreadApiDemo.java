package com.acme.edu.threadsdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadApiDemo {
    public static void main(String[] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.execute(() -> System.out.println("HW!!!"));
        pool.shutdown();
    }
}