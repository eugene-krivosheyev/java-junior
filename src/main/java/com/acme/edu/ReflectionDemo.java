package com.acme.edu;

import java.io.Serializable;
import java.util.*;

public class ReflectionDemo {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Queue queue = new Queue();
        queue.<String>sort();
    }
}

class Queue<T extends Object & Serializable> {
    private List<T> list;

    public T getHead() {return null;}
    public void add(T elem) {}
    public <P> P map(P e) { return null; }
    public <V> V sort() { V v; return null;}
}

class StringQueue extends Queue<String> {

}

class A {
    public void a() {}
}
class B extends A {
    public void b() {}
}
