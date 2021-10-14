package com.acme.edu;

import java.io.PrintStream;

public class Logger {
    private static PrintStream out = System.out;

    public static void setPrintStream(PrintStream newPrintStream) {
        out = newPrintStream;
    }

    public static void log(int message) {
        printToOutput("primitive: " + message);
    }

    public static void log(byte message) {
        printToOutput("primitive: " + message);
    }

    public static void log(char message) {
        printToOutput("char: " + message);
    }

    public static void log(String message) {
        printToOutput("string: " + message);
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

    private static void printToOutput(String message) {
        out.println(message);
    }
}
