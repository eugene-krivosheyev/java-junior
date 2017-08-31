package com.acme.edu.innerclasse;

public class InnerClassesDemo {
    public static void main(String[] args) {
        new Outer.StaticInner();
    }
}


class Outer {
    private int i;
    protected static class StaticInner {

    }
}