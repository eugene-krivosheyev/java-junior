package com.acme.edu.demo;

public class FinalDemo {
    public static final int GLOBAL_CONST;
    private final int instanceConst;

    static {
        GLOBAL_CONST = 0;
    }

    public FinalDemo(int instanceConst) {
        this.instanceConst = instanceConst;
    }

    public static void main(final String[] args) {
        final int localVar = 0;
        final Object o = new Object();
    }
}
