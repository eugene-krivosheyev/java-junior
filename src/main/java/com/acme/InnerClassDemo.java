package com.acme;

import javafx.util.Pair;

import java.util.Iterator;
import java.util.Map;

public class InnerClassDemo {
    public static void main(String[] args) {
        Outer.StaticInner object = new Outer.StaticInner();

    }
}

class Outer {
    private static int state;

    public static class StaticInner {
//        private int state;

        public void m() {
            state = 0;
        }
    }

    void m() {
        new StaticInner();
    }
}