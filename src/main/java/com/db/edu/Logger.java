package com.db.edu;

import com.db.edu.message.*;

public class Logger {
    private static ConsoleSaver consoleSaver = new ConsoleSaver();
    private static Controller controller = new Controller(consoleSaver);

    private Logger() {
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public static void log(int... message) {
        for (int current : message) {
            controller.log(new IntMessage(current));
        }
    }

    public static void log(String... message) {
        for (String current : message) {
            controller.log(new StringMessage(current));
        }
    }

    public static void flush() {
        controller.flush();
    }
}