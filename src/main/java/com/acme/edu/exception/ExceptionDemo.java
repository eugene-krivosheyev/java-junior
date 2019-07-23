package com.acme.edu.exception;

public class ExceptionDemo {
    public static void main(String... args) {
        //
        tryAndReturn();
        //
    }

    public static int tryAndReturn() {
        try {
            //
            save(); //RE("t")
            //
        } catch (RuntimeException e) {
            throw new RuntimeException("c");
        } finally {
            throw new RuntimeException("f");
        }
    }

    private static void save() {
        //
        throw new RuntimeException("t");
        //
    }
}
