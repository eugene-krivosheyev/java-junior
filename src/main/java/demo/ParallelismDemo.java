package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelismDemo {
    public static void main(String[] args) {
        /*
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread());
            }
        });
        thread.start();

        while (true) {
            System.out.println("main");
        }
        */

        final ExecutorService pool = Executors.newFixedThreadPool(100);
        pool.execute(() -> System.out.println("1"));
        pool.execute(() -> System.out.println("2"));
        pool.execute(() -> System.out.println("3"));
        pool.execute(() -> System.out.println("4"));
        pool.shutdown();
    }
}
