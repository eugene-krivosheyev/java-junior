package com.acme.edu.threadsdemo;

import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {

                }
                System.out.println("111");
            }
        });

        t.setDaemon(true);
        t.start();

        /*
        t.stop();
        t.suspend();
        t.resume();
        */

        t.setName("main | Thread-1");
        t.setPriority(Thread.MAX_PRIORITY);

        Thread.sleep(5_000);
        t.interrupt();

        t.join();


        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<String> futureResult = pool.submit(() -> "");
        futureResult.isDone();
        try {
            String result = futureResult.get();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }
    }
}
