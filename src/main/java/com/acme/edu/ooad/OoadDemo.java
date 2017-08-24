package com.acme.edu.ooad;

public class OoadDemo {
    private final int ii; //blank final
    public static final int MY_SUPER_CONST = 0;

    public OoadDemo(int i) {
        ii = 0;
    }

    static void m() {}
    public static void main(final String[] args) {
        System.out.println(Color.RED);
    }
}

enum Color {
    GREEN, RED, BLUE;
}

