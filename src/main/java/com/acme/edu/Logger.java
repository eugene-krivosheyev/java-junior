package com.acme.edu;

/**
 * This is a simple logger for some standard Java types.
 * @version 1.0
 */
public class Logger {

    /**
     * @param  message  an integer value to be logged
     */
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    /**
     * @param  message  a byte value to be logged
     */
    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    /**
     * @param  message  a char value to be logged
     */
    public static void log(char message) {
        System.out.println("char: " + message);
    }

    /**
     * @param  message  a String value to be logged
     */
    public static void log(String message) {
        System.out.println("string: " + message);
    }

    /**
     * @param message a Boolean value to be logged
     */
    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    /**
     * @param message an Object value to be logged
     */
    public static void log(Object message) {
        System.out.println("reference: " + message);
    }
}