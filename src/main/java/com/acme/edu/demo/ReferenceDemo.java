package com.acme.edu.demo;

public class ReferenceDemo {
    private static Object classState = new Object();
    private Object instanceState = new Object();

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object);

        ReferenceDemo referenceDemo = new ReferenceDemo();
    }
}
