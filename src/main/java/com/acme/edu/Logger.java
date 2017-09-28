package com.acme.edu;

import java.util.ArrayList;

/** */
public class Logger {

    /** */
    private static final int
            MSG_TYPE_BYTE = 1,
            MSG_TYPE_SHORT = 2,
            MSG_TYPE_INTEGER = 3,
            MSG_TYPE_LONG = 4,
            MSG_TYPE_STRING = 20,
            MSG_TYPE_OBJECT = 21;

    /** */
    private static int currentMsgType = 0;

    /** */
    private ArrayList<Object> logs = new ArrayList<>();

    /** */
    private static int sumBytes = 0;

    /** */
    private static int sumInts = 0;

    /** */
    private static StringBuilder sb = new StringBuilder("");

    /** */
    private static int strCounter = 0;

    /** */
    private static boolean isFlushInts = false;

    /** */
    private static boolean isFlush = false;

    /** */
    private static boolean isStop = false;

//    public static

//    /** */
//    public static void log(char message) {
//        System.out.println("primitive: " + message);
//    }

//    /** */
//    public static void log(byte message) {
//        System.out.println("primitive: " + message);
//    }

//    /** */
//    public static void log(short message) {
//        System.out.println("primitive: " + message);
//    }

    /** */
    public static void log(int message) {

        sumInts += message;
        System.out.println(String.valueOf(sumInts));

    }

//    /** */
//    public static void log(long message) {
//        System.out.println("primitive: " + message);
//    }

    /** */
    public static void log(String message) {
//            System.out.println("primitive: " + message);
        System.out.println(message + "\n");
    }

//    /** */
//    public static void log(Object message) {
//        System.out.println("primitive: " + message);
//    }

    /** */
    public static void stop() {
        isStop = true;
        flush();
    }

    /** */
    private static void flush() {
        isFlush = true;
        sb = null;
        flushInts();
    }

    /** */
    public static void flushInts() {
        isFlushInts = true;
        sumInts = 0;
    }
}
