package com.acme.edu;

public class Superman {
    private int age;

    private Superman() {
    }

    public void fly() {

    }

    public void saveTheWorld() {

    }

    //=========================

    private static Superman theOne = new Superman();

    public static Superman getTheOne() {
        return theOne;
    }
}
