package com.acme.edu.concurrency;

import java.util.Collections;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

public class JucDemo {
    public static void main(String[] args) {
        // + visibility issue solved
        java.util.concurrent.atomic.AtomicInteger ai = new AtomicInteger(5);
        int accumulator = 0;
        ai.accumulateAndGet(accumulator, Integer::sum);

//        ConcurrentSkipListSet concurrentSet;
//        Collections.synchronizedCollection(???);

    }
}
