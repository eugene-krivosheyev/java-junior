package com.acme;

import javafx.util.Pair;

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

    public class Inner {
        private int state;

        public void m() {
            Outer.this.state = 0;
        }
    }

    void m() {
    }
}