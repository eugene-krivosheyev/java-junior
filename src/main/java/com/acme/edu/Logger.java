package com.acme.edu;

import com.acme.edu.api.LoggerController;
import com.acme.edu.api.message.*;
import com.acme.edu.api.saver.ConsoleSaver;

import java.util.Arrays;

public class Logger {
    private static final LoggerController service = new LoggerController(new ConsoleSaver());

    private Logger() {
    }

    public static void log(int message) {
        service.log(new IntegerMessage(message));
    }

    public static void log(byte message) {
        service.log(new ByteMessage(message));
    }

    public static void log(char message) {
        service.log(new CharacterMessage(message));
        flush();
    }

    public static void log(String message) {
        service.log(new StringMessage(message));
    }

    public static void log(String... strings) {
        Arrays.stream(strings).forEach(str -> service.log(new StringMessage(str)));
    }

    /**
     * @param printAsArray boolean toggle to clarify how array of integers should be logged
     */
    public static void log(boolean printAsArray, int... integers) {
        service.log(new PrimitiveArrayMessage(integers, printAsArray));
        flush();
    }

    /**
     * Default way to log array of integers is to log sum
     */
    public static void log(int... integers) {
        service.log(new PrimitiveArrayMessage(integers));
        flush();
    }

    /**
     * @param printAsArray boolean toggle to clarify how 2D array of integers should be logged
     */
    public static void log(boolean printAsArray, int[][] integers) {
        service.log(new PrimitiveMatrixMessage(integers, printAsArray));
        flush();
    }

    /**
     * Default way to log 2D array of integers is to log sum
     */
    public static void log(int[][] integers) {
        service.log(new PrimitiveMatrixMessage(integers));
        flush();
    }

    public static void log(boolean message) {
        service.log(new BooleanMessage(message));
        flush();
    }

    public static void log(Object message) {
        service.log(new ObjectRefMessage(message));
        flush();
    }

    public static void flush() {
        service.flush();
    }
}
