package demo.parallelism;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.stream.IntStream.range;

public class ConcurrencyDemo {
    public static void main(String[] args) {
        final Counter counter = new Counter(0);
        ExecutorService pool = newFixedThreadPool(100);
        range(0, 100_000).forEach(e -> pool.submit(counter::increment));
        pool.shutdown();

        System.out.println(counter.getState());
    }
}

/**
 * JMM: visibility + reordering
 */
class Counter {
    private Object monitor = new Object();
    private Lock lock = new ReentrantLock(false); // ReadWriteLock
    private int state; // sharedList = Collections.syncList(new ArrayList())
    //java.util.concurrent.CopyOnWriteArraySet

    public Counter(int state) {
        this.state = state;
    }

    public void increment() {
        synchronized (monitor) {
            //....
            state++; // sharedList.add()
            //....
        }
    }

    public int getState() {
        int result;
        final boolean locked = lock.tryLock();

        lock.lock();
        try {
            //????
            result = state;
            //????
        } finally {
            lock.unlock();
        }

        return result;
    }
}