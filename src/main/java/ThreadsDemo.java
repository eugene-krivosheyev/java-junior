import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.*;

class MyThread extends Thread {
    private boolean isStoped;

    public synchronized boolean isStoped() {
        return isStoped;
    }

    public synchronized void setIsStoped(boolean isStoped) {
        this.isStoped = isStoped;
    }

    @Override
    public void run() {
        while (!isStoped) {
            System.out.println("vxcmvnbxcmvnb");
        }
    }
}

public class ThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();

        Thread.sleep(2000);

        t.setIsStoped(true);
    }
}

class Counter {
    private int count;
    private Object monitor;

    Counter(Object monitor) {
        this.monitor = monitor;
    }

    public void increment() {
        synchronized(this) {
            count++;
        }
    }

    public int getCount() {
        synchronized(this) {
            if(count > 10) return count;
            else return 0;
        }
    }
}

