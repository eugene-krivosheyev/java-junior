package demo;

import java.util.concurrent.*;

public class ParallelismDemo {
    public static void main(String[] args) throws InterruptedException {

        /*
        new Thread() {
            @Override
            public void run() {
                while (!this.isInterrupted()) {
                    //controller.log(???);
                }
                throw new RuntimeException();
            }
        }.start(); // -> IllegalStateException

        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(1_000); // or wait()
                } catch (InterruptedException e) {

                }
                //......
            }
//            throw new RuntimeException();
        });
        thread.start();

        thread.isAlive();
        thread.suspend(); thread.resume();
        thread.stop();
        thread.interrupt();
        thread.setDaemon(true);
        thread.setPriority(Thread.NORM_PRIORITY); // != astronomic time VS CPU time

        while (true) {
            System.out.println("main");
        }
        */

        //====================================//
        //Executors.newSingleThreadExecutor()
        final ExecutorService pool = Executors.newFixedThreadPool(10);
//        pool.execute(() -> { try { controller.log() } catch(Exception e) {} });
        pool.execute(() -> System.out.println("2"));
        pool.execute(() -> System.out.println("3"));
        pool.execute(() -> System.out.println("4"));

        Future<String> sometime = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "!!!!";
            }
        });
        sometime.isDone(); //????
        try {
            sometime.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown(); pool.shutdownNow();
        pool.awaitTermination(10, TimeUnit.SECONDS);
    }
}
