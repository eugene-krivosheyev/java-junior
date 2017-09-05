package com.acme.edu.threadsdemo;

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
    }
}
