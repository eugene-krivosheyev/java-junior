package com.acme.edu;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Logger {
    private static final String PRIMITIVE_NAME = "primitive";
    private static final String REFERENCE_NAME = "reference";
    private static final String CHAR_NAME = "char";
    private static final String STRING_NAME = "string";

    private static List<PrintStream> printStreams;

    static {
        printStreams = new LinkedList<>();
        printStreams.add(System.out);
    }

    public static void setPrintStreams(List<PrintStream> newPrintStreams) {
        printStreams = newPrintStreams;
    }

    private static void log(String typeName, String message) {
        for(PrintStream printStream : printStreams) {
            printStream.println(String.format("%s: %s", typeName, message));
        }
    }

    public static void log(int message) {
        log(PRIMITIVE_NAME, String.valueOf(message));
    }

    public static void log(byte message) {
        log(PRIMITIVE_NAME, String.valueOf(message));
    }

    public static void log(boolean message) {
        log(PRIMITIVE_NAME, String.valueOf(message));
    }

    public static void log(char message) {
        log(CHAR_NAME, String.valueOf(message));
    }

    public static void log(Object message) {
        log(REFERENCE_NAME, message.toString());
    }
    
    public static void log(String message) {
        log(STRING_NAME, message);
    }

}
