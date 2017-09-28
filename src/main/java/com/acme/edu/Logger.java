package com.acme.edu;

import java.util.ArrayList;

/** */
public class Logger {

    /** */
    private ArrayList<Object> logs = new ArrayList<>();

    /** */
    private int sumBytes = 0;

    /** */
    private int sumInts  = 0;

    /** */
    private int strCounter = 0;

//    public static

    /** */
    public static void log(char message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void log(short message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void log(long message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void log(String message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void log(Object message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void stopInts() {

    }

    /** */
    public static void flushInts() {

    }

    /** */
    public static void main(String[] args) {
        System.out.println("I'am is live!");
    }
}
