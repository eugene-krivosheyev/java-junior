package demo.thread.parallelism;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service();
        final ExecutorService pool = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1_000_000).forEach(i -> pool.execute(service::inc));
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(service.getState());
    }
}

class Service {
    private int state = 1;
    private Collection collection = Collections.synchronizedList(new ArrayList<>());

    /**
     * 1. <read>
     * 2. <change>
     * 3. <save>
     */
    public void inc() {
        //....
        synchronized(collection) {
            collection.add(null);
            state++;
        }
        //.....
    }

    public int getState() {
        return state;
    }
}