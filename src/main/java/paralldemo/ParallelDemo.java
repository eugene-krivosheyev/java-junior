package paralldemo;

import java.util.concurrent.*;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future<String> result = pool.submit(() -> "abc");

        result.isDone();
        try {
            result.get(10_000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        pool.shutdownNow();

    }
}

