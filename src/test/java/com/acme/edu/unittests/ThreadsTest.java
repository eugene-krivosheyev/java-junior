package com.acme.edu.unittests;

import com.acme.edu.client.LoggerClient;

public class ThreadsTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            LoggerClient.log(1);
            LoggerClient.close();
        });
        Thread thread2 = new Thread(() -> {
            LoggerClient.log(2);
            LoggerClient.close();
        });
        thread1.start();
        thread2.start();

        Thread.sleep(10000);
        Thread.sleep(10000);

        thread1.join();
        thread2.join();
    }
}
