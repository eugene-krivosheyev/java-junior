package paralldemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {
        Executor pool = Executors.newFixedThreadPool(4);
        pool.execute(() -> {
            /*
            while (!interrupted()) {
                try {
                    System.out.println(currentThread().getName());
                    sleep(100);
                } catch (InterruptedException e) {

                }
            }*/
            System.out.println("HW!!");
        });



        ((ExecutorService) pool).shutdown();
        ((ExecutorService) pool).shutdownNow();

//        while (true) {
//            sleep(100);
//            System.out.println(Thread.currentThread().getName());
//        }

    }
}

