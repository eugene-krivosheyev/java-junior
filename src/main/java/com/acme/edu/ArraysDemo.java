package com.acme.edu;

public class ArraysDemo {
    public static void main(String... args) {
        Counter factual = new Counter();
        m(factual);
        System.out.println(factual.getCounter());
    }

    private static void m(Counter formal) {
        formal.increment();
    }
}

class Counter {
    private int counter;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
