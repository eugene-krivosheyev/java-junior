package com.acme.edu;

import java.util.Arrays;
import java.util.Objects;

public class Logger {

    private static int bufferSum;
    private static String bufferString = null;
    private static int stringCounter = 1;
    private static String previousType = "start";
    private static String messagePrefix = "";
    private static String type="";

    public static void log(String... args) {
        for (String arg : args) {
            log(arg);
        }
        flush();
    }

    public static void log(int... args) {
        messagePrefix = "";
        print(formatMessage(sumOfArray(args)));
    }

    public static void log(int[][] arr) {
        messagePrefix = "";
        print(formatMessage(sumOfArray2D(arr)));
    }

    public static void log(int message) {
        /**
         * @throws
         * @param message
         */
        type = "int";
        processingForIntAndByte(message);
    }

    public static void log(byte message) {
        type = "byte";
        processingForIntAndByte(message);
    }

    public static void log(char message) {
        messagePrefix = "char: ";
        print(formatMessage(message));
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
        messagePrefix = "string: ";
        previousType = type;
        bufferSum = 0;
        bufferString = message;
    }

    public static void log(boolean message) {
        messagePrefix = "primitive: ";
        print(formatMessage(message));
    }

    public static void log(Object message) {
        messagePrefix = "reference: ";
        print(formatMessage(message));
    }

    public static void flush() {
        if (previousType != "start" && (previousType == "int" || previousType == "byte")) {
            print(formatMessage(bufferSum));
        } else if (previousType != "start" && previousType == "str") {
            if (stringCounter == 1) {
                print(formatMessage(bufferString));
            } else {
                print(formatMessage(bufferString + " (x" + stringCounter + ")"));
            }
        }
        bufferSum = 0;
        stringCounter = 1;
    }

    private static String formatMessage(Object message) {
        return messagePrefix + message;
    }

    private static void print(String message) {
        System.out.println(message);
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

    private static void processingForIntAndByte(int message) {
        messagePrefix = "primitive: ";
        int maxValue = (type == "int") ? Integer.MAX_VALUE : Byte.MAX_VALUE;
        if (type != previousType) {
            flush();
            previousType = type;
            bufferSum += message;
        } else {
            if ((Long.valueOf(bufferSum) + Long.valueOf(message)) < maxValue) {
                bufferSum += message;
            } else {
                print(formatMessage(maxValue));
                bufferSum = message - (maxValue - bufferSum);
            }
        }
    }

}
