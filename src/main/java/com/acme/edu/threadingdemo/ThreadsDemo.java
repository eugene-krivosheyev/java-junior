package com.acme.edu.threadingdemo;

public class ThreadsDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread-1");
            }
        });
        thread.start();


        while (true) {
            System.out.println("main");
        }


    }
}