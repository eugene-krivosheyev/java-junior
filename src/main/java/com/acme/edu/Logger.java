package com.acme.edu;

import com.acme.edu.messageOut.Formatter;
import com.acme.edu.messageOut.Printer;

import java.util.Arrays;
import java.util.Objects;

public class Logger {

    private static int bufferSum;
    private static String bufferString = null;
    private static int stringCounter = 1;
    private static String previousType = "start";
    //    private static String messagePrefix = "";
    private static String type = "";
    private static Printer printer = new Printer();
    private static Formatter formatter = new Formatter();

    public static void log(String... args) {
        for (String arg : args) {
            log(arg);
        }
        flush();
    }

    public static void log(int... args) {
        formatter.setMessagePrefix("");
        printer.print(formatter.formatMessage(sumOfArray(args)));
    }

    public static void log(int[][] arr) {
        formatter.setMessagePrefix("");
        printer.print(formatter.formatMessage(sumOfArray2D(arr)));
    }

    public static void log(int message) {
        type = "int";
        processingForIntAndByte(message);
    }

    public static void log(byte message) {
        type = "byte";
        processingForIntAndByte(message);
    }

    public static void log(char message) {
        formatter.setMessagePrefix("char: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void log(String message) {
        type = "str";
        if (type != previousType) {
            flush();
        } else {
            if (Objects.equals(message, bufferString)) {
                stringCounter++;
            } else {
                flush();
                stringCounter = 1;
            }
        }
        formatter.setMessagePrefix("string: ");
        previousType = type;
        bufferSum = 0;
        bufferString = message;
    }

    public static void log(boolean message) {
        formatter.setMessagePrefix("primitive: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void log(Object message) {
        formatter.setMessagePrefix("reference: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void flush() {
        if (previousType != "start" && (previousType == "int" || previousType == "byte")) {
            printer.print(formatter.formatMessage(bufferSum));
        } else if (previousType != "start" && previousType == "str") {
            if (stringCounter == 1) {
                printer.print(formatter.formatMessage(bufferString));
            } else {
                printer.print(formatter.formatMessage(bufferString + " (x" + stringCounter + ")"));
            }
        }
        bufferSum = 0;
        stringCounter = 1;
    }


    private static int sumOfArray(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    private static int sumOfArray2D(int[][] arr) {
        int sum = 0;
        for (int[] array : arr) {
            sum += sumOfArray(array);
        }
        return sum;
    }


}
