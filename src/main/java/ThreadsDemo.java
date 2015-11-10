import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        //region overthread demo
        /*
        for (int count = 0; count < 1_000; count++) {
            Thread.sleep(5);
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(10);
                        Thread.sleep(10);
                        Thread.sleep(10);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        */
        //endregion

        ExecutorService pool = Executors.newFixedThreadPool(5);
         int i = 7;
        pool.execute(() -> {
            System.out.println("HHHHHH" + i);
        });
        pool.execute(new MyWorker(new Object()));

        Future<Integer> f = pool.submit(() -> {return 6;});

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //1
                //2
                System.out.println("Hello world!");
            }
        });

        thread.start();
        thread.suspend(); thread.resume();
        thread.stop();
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);

    }
}

class MyWorker implements Runnable {
    private Object logger;

    public MyWorker(Object logger) {
        this.logger = logger;
    }


    @Override
    public void run() {
        System.out.println(logger);
    }
}
