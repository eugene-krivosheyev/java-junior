package com.acme.edu;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public class Logger {
    private static final String PRIMITIVE_NAME = "primitive";
    private static final String REFERENCE_NAME = "reference";
    private static final String CHAR_NAME = "char";
    private static final String STRING_NAME = "string";
    private static final String FORMAT_STRIMG = "%s: %s";

    private static List<PrintStream> printStreams;
    private static StringBuffer buffer = new StringBuffer();
    private static String currentString;
    private static int currentStringCount;
    private static int currentIntSum;
    private static byte currentByteSum;
    private static Type currentType = Type.UNDEFINED;

    static {
        printStreams = new LinkedList<>();
        printStreams.add(System.out);
    }

    public static void flush() {
        for(PrintStream printStream : printStreams) {
            switch (currentType) {
                case INT:
                    printStream.println(String.format(FORMAT_STRIMG, PRIMITIVE_NAME, currentIntSum));
                    currentIntSum = 0;
                    break;
                case BYTE:
                    printStream.println(String.format(FORMAT_STRIMG, PRIMITIVE_NAME, currentByteSum));
                    currentByteSum = 0;
                    break;
                case STRING:
                    printStream.println(String.format("%s: %s" +
                            ((currentStringCount > 1) ? String.format(" (x%d)", currentStringCount) : ""),
                            STRING_NAME,
                            currentString
                    ));
                    currentString = "";
                    currentStringCount = 0;
                    break;
            }
            currentType = Type.UNDEFINED;
        }
    }

    public static void setPrintStreams(List<PrintStream> newPrintStreams) {
        printStreams = newPrintStreams;
    }

    public static void addPrintStream(PrintStream printStream) {
        printStreams.add(printStream);
    }

    public static void log(int message) {
        if (currentType != Type.INT || abs(currentIntSum) > Integer.MAX_VALUE - abs(message)) {
            flush();
        }
        currentIntSum += message;
        currentType = Type.INT;
    }

    public static void log(byte message) {
        if (currentType != Type.BYTE || abs(currentByteSum) > Byte.MAX_VALUE - abs(message)) {
            flush();
        }
        currentByteSum += message;
        currentType = Type.BYTE;
    }

    public static void log(boolean message) {
        log(PRIMITIVE_NAME, String.valueOf(message));
    }

    public static void log(char message) {
        log(CHAR_NAME, String.valueOf(message));
    }

    public static void log(Object message) {
        log(REFERENCE_NAME, Objects.toString(message, "null"));
    }

    public static void log(String message) {
        if (currentType != Type.STRING || !currentString.equals(message)) {
            flush();
        }
        currentString = message;
        currentStringCount++;
        currentType = Type.STRING;
    }

    private static void log(String typeName, String message) {
        for(PrintStream printStream : printStreams) {
            printStream.println(String.format("%s: %s", typeName, message));
        }
    }

}
