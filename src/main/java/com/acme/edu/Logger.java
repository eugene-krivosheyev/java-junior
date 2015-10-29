package com.acme.edu;

public class Logger {
    private static String msg = "primitive: ";

    /**
     * Method call "print" with parameter int
     * @param message
     */
    public static void log(int message) {
        print(msg + message);
    }

    /**
     * Method call "print" with parameter boolean
     * @param message
     */
    public static void log(boolean message) {
        print(msg + message);
    }

    /**
     * Method call "print" with parameter char
     * @param message
     */
    public static void log(char message) {
        print("char: " + message);
    }

    public static void main(String[] args) {

    }

    /**
     * Prints a String and then terminate the line.
     * @param str
     */
    public static void print(String str) {
        System.out.println(str);
    }
}
