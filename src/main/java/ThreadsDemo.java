import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.*;

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

        //region future
        /*
        ExecutorService service =
                Executors.newFixedThreadPool(2);
        Future<String> f = service.submit(() -> {
            throw new Exception("zzz");
        });

        try {
            System.out.println(f.get());
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }

        service.shutdownNow();
        */
        //endregion

        //region interrupt
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    Thread.currentThread().getName();
                    System.out.println("Hello world!");
                }
            }
        });
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        //endregion

    }
}