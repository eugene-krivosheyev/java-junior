package demo.thread.parallelism;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.execute(() -> {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        ececute(() -> ???)
//            .andThen(() -> ???)
//            .andthenParall(()->??,()->??)
//            .andAfterBoth((r1,r2) -> ????);

        final Future<String> promise = pool.submit(() -> {
            Thread.sleep(5_000);
            return "RESULT";
        });

        promise.isDone();
        try {
            promise.get(10, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Thread.sleep(6_000);


        pool.shutdown();
//        pool.shutdownNow();
        pool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("main exit");
    }
}
