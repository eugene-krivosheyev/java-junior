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
    private List queue = new LinkedList();

    public Object get() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            return queue.remove(0);
        }
    }

    public void add(Object ele) {
        synchronized (queue) {
            queue.add(ele);
        }
    }
}
