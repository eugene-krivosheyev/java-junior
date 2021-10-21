package com.acme.edu;

import java.io.PrintStream;

public class Logger {
    private static PrintStream out = System.out;

    static LoggerController controller = new LoggerController();


    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.log(message);
    }

    public static void log(byte message) {
        controller.log(message);
    }

    public static void log(char message) {
        printToOutput("char: " + message);
    }

    public static void log(String message) {
        controller.log(message);
    }

    public static void log(boolean message) {
        printToOutput("boolean: " + message);
    }

    public static void log(Object message) {
        if (message == null) {
            printToOutput("null");
            return;
        }
        printToOutput("reference: " + message.toString());
    }

    public static void log(int... array) {
        printToOutput("arrays's sum: " + getSumOfArray(array));
    }
    public static void log(int[]... array) {
        int sum = 0;
        for (int[] subArray: array) {
            sum += getSumOfArray(subArray);
        }
        printToOutput("matrix sum: " + sum);
    }
    public static void log(String... array) {
        for (String value: array) {
            log(value);
        }
    }

    private static int getSumOfArray(int... array) {
        int sum = 0;
        for (int value: array) {
            sum += value;
        }
        return sum;
    }

    private static void printToOutput(String message) {
        out.println(message);
    }

}
