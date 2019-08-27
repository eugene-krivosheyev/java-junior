package com.acme.edu.demo;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.m(5).toString());
    }
}

class Outer {
    private static int staticState = 1;
    private int instanceState = 2;

    public Object m(int param) {
        int localVar = param;

        class Inner extends Object {
            @Override
            public String toString() {
                return staticState + " " + instanceState + " " + localVar;
            }
        }

        return new Inner();
    }
}