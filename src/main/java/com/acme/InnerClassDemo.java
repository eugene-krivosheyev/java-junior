package com.acme;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class InnerClassDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        Outer.Inner i = new Outer().new Inner();
    }
}

class Outer {
    private int state;

    public Comparator m() {
        class MyComparator implements Comparator {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            } //aka Local
        }

        return new MyComparator();
    }
}

