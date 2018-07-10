package com.acme.edu;

import com.acme.edu.Saver.ConsoleSaver;
import com.acme.edu.Saver.Saver;

import java.io.Console;

public class Logger {
    private static long integerChainSum;

    private static int bufferedStringCounter = 0;
    private static StringBuffer bufferedString;

    private static LogWorker logWorker = new LogWorker(new ConsoleSaver());

    public static void flushIntegerBuffer() {
        logWorker.flushIntegerBuffer();
    }

    public static void flushStringBuffer() {
        if (bufferedString != null) {
            String decoratedString = "string: " + bufferedString;
            if (bufferedStringCounter > 1) {
                decoratedString += " (x" + bufferedStringCounter + ")";
            }
            output(decoratedString);
            bufferedStringCounter = 0;
            bufferedString = null;
        }
    }

    public static void log(int message) {
        logWorker.log(message);
    }

    public static void log(byte message) {
        logWorker.log(message);
    }

    public static void log(char message) {
        logWorker.log(message);
    }

    public static void log(String message) {
        logWorker.log(message);
    }

    public static void log(boolean message) {
        logWorker.log(message);
    }

    public static void log(Object message) {
        logWorker.log(message);
    }

    public static void log(int[] message) {
        System.out.print("primitives array: ");
        logArray(message);
    }

    public static void log(int[][] message) {
        System.out.println("primitives matrix: {");
        for (int[] innerArray: message) {
            logArray(innerArray);
        }
        System.out.println("}");
    }

    private static void logArray(int[] message) {
        System.out.print("{");
        for (int i = 0; i < message.length; i++) {
            if (i>0) {
                System.out.print(", ");
            }
            System.out.print(message[i]);

        }
        System.out.println("}");
    }

    public static void flushBuffers() {
        flushStringBuffer();
        flushIntegerBuffer();
    }

    private static void output(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
