package com.acme.edu.concurrency;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ServerAppDemo {
    public static void main(String[] args) {
        final ServerController controller = new ServerController();

        controller.executeAdd(1);
        controller.executeAdd(2);

        System.out.println(controller.executeSum());
    }
}

class ServerController {
    private Set<Integer> data = new HashSet<>();

    /**
     * Concurrent execution
     */
    public void executeAdd(int param) {
        synchronized (this) {
            data.add(param);
        }
    }

    public int executeSum() {
        synchronized (this) {
            return data.stream()
                    .reduce(0, Integer::sum);
        }
    }
}
