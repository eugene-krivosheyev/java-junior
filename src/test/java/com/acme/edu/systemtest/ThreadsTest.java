package com.acme.edu.systemtest;

import com.acme.edu.client.Proxy;

public class ThreadsTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            Proxy.log(1);
            Proxy.close();
        });
        Thread thread2 = new Thread(() -> {
            Proxy.log(2);
            Proxy.close();
        });
        thread1.start();
        thread2.start();

        Thread.sleep(10000);
        Thread.sleep(10000);

        thread1.join();
        thread2.join();
    }
}
