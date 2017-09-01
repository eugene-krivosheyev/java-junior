package genericsdemo;

import java.util.*;

import static genericsdemo.Pair.*;

public class GenericsDemo {
    public static void main(String[] args) {
        Pair<? extends Number, String> p1 = new Pair<Integer, String>(1, "a");

        Pair.<Integer>sum();
        Integer i = Pair.m(Integer.class);
    }
}

class Pair<K extends Number, V> {
    private K k;
    private V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public static <T> T sum() {
        return null;
    }

    public static <T> T m(Class<T> typeInfo) {
        return null;
    }
}

class Connector<T> {
    public T getConnction() {
        return null;
    }
}


interface Queue<E> {
    E pop();
    void push(E e);
}

class MyQueue1 implements Queue {
    @Override
    public Object pop() {
        return null;
    }

    @Override
    public void push(Object o) {

    }
}

class MyQueue2 implements Queue<String> {
    @Override
    public String pop() {
        return null;
    }

    @Override
    public void push(String s) {

    }
}

class MyQueue3<T> implements Queue<T> {
    @Override
    public T pop() {
        return null;
    }

    @Override
    public void push(T t) {

    }
}

class MyQueue4<String> implements Queue {
    @Override
    public Object pop() {
        return null;
    }

    @Override
    public void push(Object o) {
        Arrays.asList("12", 12);
    }
}

class GenericsDemoWithLambda {
    public static void main(String[] args) {
        Collections.sort(
                Arrays.asList((int)12, (byte)12),
                (o1, o2) -> 1
        );
    }
}