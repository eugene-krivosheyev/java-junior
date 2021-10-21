package com.acme.edu;

import com.acme.edu.messages.*;

import java.io.PrintStream;

public class Logger {
    private static PrintStream out = System.out;

    private static LoggerController controller = new LoggerController();


    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public static void log(int... array) {
        controller.log(new IntArrayMessage(array));
    }
    public static void log(int[]... array) {
        controller.log(new IntTwoDimensionalArrayMessage(array));
    }
    public static void log(String... array) {
        for (String value: array) {
            controller.log(new StringMessage(value));
        }
    }
}
