package com.acme.edu.demo;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer.Inner object = new Outer.Inner();
        object.m();
    }
}

class Outer {
    private static int staticState = 1;
    private int instanceState = 2;

    public static class Inner {
        public void m() {
            staticState = 2;
            System.out.println(staticState);
            new Outer();
        }
    }
}