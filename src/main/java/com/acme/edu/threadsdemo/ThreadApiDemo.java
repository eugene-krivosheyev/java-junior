package com.acme.edu.threadsdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadApiDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println("HW!"));
        thread.start();

        thread.stop();
        thread.getName(); //Thread-1
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setDaemon(true);
        thread.suspend(); thread.resume();

        System.out.println(Thread.currentThread().getName());
        Thread.yield();

        //TODO interrupt, states
    }
}