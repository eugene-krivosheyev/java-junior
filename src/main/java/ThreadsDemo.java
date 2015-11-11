import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.*;

class ThreadDemo {
    public static void main(String[] args) {
        BlockingQueue q = new BlockingQueue();
        q.add(new Object());
        try {
            Object o = q.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class BlockingQueue {
    private static final int MAX_SIZE = 6;
    private List queue = new LinkedList();
    private boolean isStopped;

    public Object get() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty() && !isStopped) {
                queue.wait();
            }
            return queue.remove(0);
        }
    }

    public void add(Object element) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() > MAX_SIZE) {
                queue.wait();
            }
            queue.add(element);
            queue.notify();
        }
    }

    public void stop() {
        synchronized(queue) {
            isStopped = true;
            queue.notifyAll();
        }
    }

}
