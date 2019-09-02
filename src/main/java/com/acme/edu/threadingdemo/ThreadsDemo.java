package com.acme.edu.threadingdemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.currentThread;

public class ThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (!this.isInterrupted()) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    Thread.yield();
            }
        };
        final Thread thread2 = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }
        });
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();

        Thread.sleep(100_000);

        thread1.stop(); thread1.interrupt();
        thread2.interrupt();

        thread1.suspend(); thread1.resume();

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.join();
        thread2.join();
        System.out.println("Выжил только один!!!!");
        System.out.println(thread1.isAlive());
        System.out.println(thread2.isAlive());
        System.out.println(currentThread().isAlive());

        for (Thread.State state : Thread.State.values()) {
            System.out.println(state.name());
        }
    }
}