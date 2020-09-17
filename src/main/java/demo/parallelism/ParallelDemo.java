package demo.parallelism;


import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread someThread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("thread-01");
            }
        });
        someThread.setDaemon(true);
        someThread.start();
        someThread.getName(); //Thread-01
        someThread.setPriority(Thread.MAX_PRIORITY);

        someThread.isAlive();
        someThread.getState();

        someThread.suspend();
        someThread.resume();
        someThread.stop();
        someThread.interrupt(); //someThread.isInterrupted();

        someThread.join();
        Thread.yield();

        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.execute(() -> {
            System.out.println(Thread.currentThread());
        });
        pool.execute(() -> { /*while (true) ;*/ });
        pool.execute(() -> System.out.println("thread-3"));
        pool.execute(() -> System.out.println("thread-4"));
        pool.execute(() -> System.out.println("thread-5"));

        pool.shutdown();
//        final List<Runnable> alreadyQueued = pool.shutdownNow();
//        pool.awaitTermination(1, TimeUnit.SECONDS);
    }
}

