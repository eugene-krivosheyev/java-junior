package thredsdemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsDemo {
    public static void main(String[] args) {
        Thread workerMinion = new Thread(() -> {
            while (true) {
                System.out.println("thread-1");
            }
        });

        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> System.out.println("HHHH!!!!"));
        pool.shutdownNow();

        System.out.println(workerMinion.getName());
        System.out.println(Thread.currentThread().getName());

        workerMinion.setPriority(Thread.MAX_PRIORITY);
        workerMinion.setDaemon(true);
//        workerMinion.start();

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        Thread.currentThread().setDaemon(true);

//        workerMinion.stop();
//        workerMinion.suspend();//wait
//        workerMinion.resume();//notify

//        while (true) {
//            System.out.println("main");
//        }
    }
}
