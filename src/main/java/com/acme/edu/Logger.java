package com.acme.edu;

import static com.acme.edu.Logger.log;

public class Logger {
    static int globalState;
    int instanceState;

    /**
     * Pass by value: for primitives
     * Pass by reference: for reference types
     */
    public static void log(IntHolder message) { //Formal parameter
        message.setValue(2);
        System.out.println("primitive: " + message.getValue());
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void main(String[] args) {
        IntHolder intHolder = new IntHolder(1);
        Logger.log(intHolder); //Factual parameter
        System.out.println(intHolder.getValue());
    }
}

class IntHolder {
    private int value;

    public IntHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}