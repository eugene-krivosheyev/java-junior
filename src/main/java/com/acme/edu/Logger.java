package com.acme.edu;

import com.acme.edu.messageOut.Formatter;
import com.acme.edu.messageOut.Printer;
import com.acme.edu.processors.ServiceForIntAndByte;

import java.util.Arrays;
import java.util.Objects;

public class Logger {

    private static Printer printer = new Printer();
    private static Formatter formatter = new Formatter();
    private static Stater state = new Stater("", "start", 0, null, 1);
    private static Flusher flusher = new Flusher(formatter, printer, state);
    private static ServiceForIntAndByte serviceForIntAndByte = new ServiceForIntAndByte(formatter, printer, state, flusher);

    public static void log(String... args) {
        for (String arg : args) {
            log(arg);
        }
        flusher.flush();
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
        state.setType("int");
        serviceForIntAndByte.processingForIntAndByte(message);
    }

    public static void log(byte message) {
        state.setType("byte");
        serviceForIntAndByte.processingForIntAndByte(message);
    }

    public static void log(char message) {
        formatter.setMessagePrefix("char: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void log(String message) {
        state.setType("str");
        if (state.getType() != state.getPreviousType()) {
            flusher.flush();
        } else {
            if (Objects.equals(message, state.getBufferString())) {
                state.setStringCounter(state.getStringCounter() + 1);
            } else {
                flusher.flush();
                state.setStringCounter(1);
            }
        }
        formatter.setMessagePrefix("string: ");
        state.setPreviousType(state.getType());
        state.setBufferSum(0);
        state.setBufferString(message);
    }

    public static void log(boolean message) {
        formatter.setMessagePrefix("primitive: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void log(Object message) {
        formatter.setMessagePrefix("reference: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void flush(){
        flusher.flush();
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
