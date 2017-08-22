package com.acme.edu;

import static com.acme.edu.Logger.log;

public class Logger {
    static int globalState;
    int instanceState;

    /**
     * Pass by value: for primitives
     */
    public static void log(int message) { //Formal parameter
        message = 2;
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void main(String[] args) {
        int message = 1;
        Logger.log(message); //Factual parameter
        System.out.println(message);
    }
}
