package com.acme.genericsdemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Arrays.asList;

public class GenericsQueue<T extends String> {
    private T state;

    public void enqueue(T element) {

    }

    public T dequeue() {
        return null;
    }

    public static <P> P sort(P arg) {
        return null;
    }

    public static <U> U sort() {
        return null;
    }
}

class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        GenericsQueue<Integer> queue
                = new GenericsQueue<>();//Type Erasure
        queue.enqueue(new Integer(1));

        GenericsQueue.sort("");
        GenericsQueue.<String>sort();

        Collections.sort(
                asList(1, 2, 3, 4),
                (o1, o2) -> 0
        );

    }
}

interface Queue<T> {
    void enqueue(T element);
}

class MyQueue1 implements Queue<String> {
    @Override
    public void enqueue(String element) {

    }
}

class MyQueue2<T> implements Queue<T> {
    @Override
    public void enqueue(T element) {

    }
}

class MyQueue3<String> implements Queue<Object> {
    @Override
    public void enqueue(Object element) {

    }
}
