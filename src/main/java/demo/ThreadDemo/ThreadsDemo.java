package demo.ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsDemo {
    public static void main(String[] args) {
        ExecutorService pool
                = Executors.newFixedThreadPool(4);

        pool.execute(() -> {
            while(!interr) {

            }
        });
        pool.execute(() -> {
            System.out.println("t2");
        });

        pool.shutdown();

    }
}
