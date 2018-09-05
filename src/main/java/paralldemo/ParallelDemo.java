package paralldemo;

import java.util.concurrent.*;

import static java.lang.Thread.interrupted;

public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        pool.execute(() -> {
            int count = 0;
            try {
                while (!interrupted()) {
                    System.out.println(count++);
                    Thread.sleep(5_000);
                }
            } catch (InterruptedException e) {

            }
        });

        System.out.println("before shutdown");
        pool.shutdownNow();
        System.out.println("after shutdown");
    }
}

