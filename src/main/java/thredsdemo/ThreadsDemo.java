package thredsdemo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadsDemo {
    public static void main(String[] args) {
        Thread workerMinion = new Thread(() -> {
            while (!Thread.interrupted()) {
                //bo.bm();
            }
        });

        Thread minion = new Thread() {
            @Override
            public void run() {
                while (!this.isInterrupted()) {

                }
            }
        };

        minion.interrupt();

        try {
            minion.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> System.out.println("HHHH!!!!"));
        pool.shutdownNow();

        System.out.println(workerMinion.getName());
        System.out.println(Thread.currentThread().getName());

        workerMinion.setPriority(Thread.MAX_PRIORITY);
        workerMinion.setDaemon(true);
        workerMinion.start();

//        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//        Thread.currentThread().setDaemon(true);

//        workerMinion.stop();
//        workerMinion.suspend();//wait
//        workerMinion.resume();//notify

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        while (true) {
//            System.out.println("main");
//        }
    }
}

class Counter {
    private volatile int count; //

    public synchronized void increment() {
            count++;
    }

    public  void decrement() {
        count--;
    }
}

class MyWorkerThread extends Thread {
    private boolean flag = false;

    @Override
    public void run() {
        while (!isFlag()) {

        }
    }

    public void setFlag() { //Happns-before
        this.flag = true;
    }

    public synchronized boolean isFlag() {
        return flag;
    }

    public static void main(String[] args) throws InterruptedException {
        MyWorkerThread t = new MyWorkerThread();
        t.start();

        Thread.sleep(1_000);

        t.setFlag();
    }
}


class BlockingQueue<T> {
    private List<T> queue = new LinkedList<T>();

    public void add(T element) {
        synchronized (queue) {
            queue.add(element);
            queue.notify();
        }
    }

    public T pop() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.remove(0);
        }
    }


    public static void main(String[] args) {
        BlockingQueue q = new BlockingQueue();
        System.out.println(q.pop());
    }
}