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
        int localVar = 1; //Effectively final

        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                state = 0;
                System.out.println(localVar);

                return 0;
            }
        };
    }
}

