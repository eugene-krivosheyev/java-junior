package concurrencydemo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreadSync {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new BlockingQueue<>();
        queue.add("1");
    }
}

class BlockingQueue<T> {
    private List<T> queue = new LinkedList<>();


    public void add(T element) {
        synchronized(queue) {
            if (queue.size() > 10) {
                try {
                    while (queue.size() > 10 ) {
                        queue.wait(10_000);
                    }
                } catch (InterruptedException e) {
                    //????
                }
            } else  {
                queue.add(element);
            }
        }
    }

    public T get() {
        synchronized (queue) {
            if (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {

                }
            } else {
                T object = queue.remove(0);
                queue.notifyAll();
                return object;
            }
        }
    }
}
