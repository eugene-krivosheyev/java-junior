package demo.parallelism;

import java.util.LinkedList;
import java.util.List;

public class WaitNotifyDemo {
    public static void main(String[] args) {

    }
}


class BlockingQueue<T> {
    private List<T> queue = new LinkedList<>();

    public void offer(T element) {
        synchronized (queue) {
            queue.add(element);
            queue.notifyAll();
        }
    }

    public T poll() {
        synchronized (queue) {
            if (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
            return queue.remove(0);
        }
    }
}
