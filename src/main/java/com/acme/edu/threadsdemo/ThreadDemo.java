package com.acme.edu.threadsdemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> submit = executorService.submit(() -> {
            Thread.sleep(5_000);
            return "";
        });
        submit.isDone(); //polling
        try {
            String result = submit.get();//
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }

        executorService.shutdownNow();
    }
}
