package com.acme.edu.threadsdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadApiDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    System.out.println("thread-1");
                    try {
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) { }
                }
            }
        });
        thread.isInterrupted();

        thread.start();

        thread.stop();
        thread.getName(); //Thread-1
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setDaemon(true);
        thread.suspend(); thread.resume();

        System.out.println(Thread.currentThread().getName());
        Thread.yield();

        thread.interrupt(); // != stop()
        //TODO interrupt
        //Thread States: NEW -> RUNNABLE <-> RUNNING -> IO Blocked, Sleep, Syncronized, Wait pool -> DEAD


        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Delayer {
    public void delay(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}