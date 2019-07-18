package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleLoggerSaver());

    public static void flush() {
        loggerController.flush();
    }

    public static void close() {
        flush();
        loggerController = new LoggerController(new ConsoleLoggerSaver());
    }

    public static void log(int message) {
        loggerController.log(new IntCommand(message));
    }

    public static void log(int... message) {
        loggerController.log(new IntMasCommand(message));
    }

    public static void log(int[][] message) {
        loggerController.log(new IntMas2Command(message));
    }

    public static void log(int[][][][] message) {
        loggerController.log(new IntMas4Command(message));
    }

    public static void log(byte message) {
        loggerController.log(new ByteCommand(message));
    }

    public static void log(char message) {
        loggerController.log(new CharCommand(message));
    }

    public static void log(String message) {
        loggerController.log(new StringCommand(message));
    }

    public static void log(String... message) {
        for(String s:message)
            loggerController.log(new StringCommand(s));
    }

    public static void log(Boolean message) {
        loggerController.log(new BooleanCommand(message));
    }

    public static void log(Object message) {
        loggerController.log(new ObjectCommand(message));
    }
}
