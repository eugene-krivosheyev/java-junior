package com.acme.edu.demo;

public class VarargsDemo {
    public static void main(String[] args) {
        out(1,2,3);
    }

    public static void out(Object p1, Object... params) {
        for (Object param : params) {
            System.out.println(param);
        }
    }
}
