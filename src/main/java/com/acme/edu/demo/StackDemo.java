package com.acme.edu.demo;

public class StackDemo {
    public static void main(String[] args) {
        int localVar = 0;
        f(localVar); //by value
        System.out.println(localVar);
    }

    private static void f(int localVar) {
        localVar = 1;
    }
}
