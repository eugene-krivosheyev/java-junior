package com.acme.edu;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public class Logger {

    private static final String FORMAT_STRING = "%s: %s";

    private static List<PrintStream> printStreams;
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
                    save(printStream, getFormattedMessage(currentIntSum));
                    currentIntSum = 0;
                    break;
                case BYTE:
                    save(printStream, getFormattedMessage(currentByteSum));
                    currentByteSum = 0;
                    break;
                case STRING:
                    save(printStream, getFormattedMessage(currentString));
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
        if (currentType != Type.INT) {
            flush();
            currentType = Type.INT;
        } else if (checkTypeOverflow(currentIntSum, message, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            flush();
            currentType = Type.INT;
        }
        currentIntSum += message;
    }

    public static void log(byte message) {
        if (currentType != Type.BYTE) {
            flush();
            currentType = Type.BYTE;
        } else if (checkTypeOverflow(currentByteSum, message, Byte.MIN_VALUE, Byte.MAX_VALUE)) {
            flush();
            currentType = Type.BYTE;
        }
        currentByteSum += message;
    }

    public static void log(boolean message) {
        save(Type.BOOL, String.valueOf(message));
    }

    public static void log(char message) {
        save(Type.CHAR, String.valueOf(message));
    }

    public static void log(Object message) {
        save(Type.REFERENCE, Objects.toString(message, "null"));
    }

    public static void log(String message) {
        if (currentType != Type.STRING) {
            flush();
            currentType = Type.STRING;
        } else if(!currentString.equals(message)) {
            flush();
            currentType = Type.STRING;
        }
        currentString = message;
        currentStringCount++;
    }

    public static void log(int ... message) {
        save(Type.PRIMITIVES_ARRAY, getFormattedMessage(message));
    }

    public static void log(int [][] message) {
        save(Type.PRIMITIVES_MATRIX,getFormattedMessage(message));
    }

    private static void save(Type newType, String convertedMessage) {
        flush();
        currentType = newType;
        for(PrintStream printStream : printStreams) {
            printStream.println(String.format("%s: %s", currentType.getValue(), convertedMessage));
        }
    }

    private static boolean checkTypeOverflow(long currentSum, long term, long minValue, long maxValue) {
        return (term > 0 && currentSum > maxValue - term) ||
                (term < 0 && currentSum < minValue - term);
    }

    private static void save(PrintStream printStream, String convertedMessage) {
        printStream.println(convertedMessage);
    }

    private static String getFormattedMessage(String currentString){
        String postfixForRepeatedStrings = (currentStringCount > 1) ? String.format(" (x%d)", currentStringCount) : "";
        return String.format(FORMAT_STRING + postfixForRepeatedStrings,
                currentType.getValue(),
                currentString);

    }

    private static String getFormattedMessage(int currentSum){
        return String.format(FORMAT_STRING, currentType.getValue(), currentSum);
    }

    private static String getFormattedMessage(int[] array) {
        return Arrays.toString(array)
                .replace('[', '{')
                .replace(']', '}');
    }

    private static String getFormattedMessage(int [][] array){
        StringBuilder arrayStringBuilder = new StringBuilder();
        arrayStringBuilder
                .append('{')
                .append(System.lineSeparator());
        for (int[] arr: array) {
            arrayStringBuilder
                    .append(getFormattedMessage(arr))
                    .append(System.lineSeparator());
        }
        arrayStringBuilder
                .append('}');
        return arrayStringBuilder.toString();
    }

    public static void main(String[] args) {
        Logger.log(Byte.MAX_VALUE);
        Logger.log((byte)2);
        Logger.log("SRE");
        Logger.log("SRE");
        Logger.log(1);
        Logger.log(2);
        Logger.flush();
    }

}
