package com.acme.edu.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {

            }
        });
        thread.start();
        thread.interrupt();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (!this.isInterrupted()) {
                    //lkklllk
                    Thread.yield();
                    //lllll
                }
            }
        };
        thread1.start();
        thread1.interrupt();



        thread.start();
        thread.stop();
        thread.suspend(); thread.resume();

        thread.setDaemon(true);
        thread.setName(""); thread.getName();


        thread.join();

        thread.setPriority(Thread.MAX_PRIORITY);
    }
}

