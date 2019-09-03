package com.acme.edu.concurrency;

import java.util.LinkedList;
import java.util.List;

public class ThreadSynchronizationDemo {
    public static void main(String[] args) {
        final BlockingQueue<Object> queue = new BlockingQueue<>(10);
        queue.get();
    }
}

class BlockingQueue<T> {
    private final List<T> elements = new LinkedList<>();
    private int size;

    BlockingQueue(int size) {
        this.size = size;
    }

    public void add(T element) {
        synchronized (elements) {
            elements.add(element);
            elements.notify();
        }
    }

    public T get() {
        synchronized (elements) {
            while (elements.isEmpty()) {
                try {
                    elements.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
            return elements.remove(0);
        }
    }
}
