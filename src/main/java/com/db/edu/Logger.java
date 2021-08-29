package com.db.edu;

import com.db.edu.message.*;
import com.db.edu.saver.ConsoleSaver;

public class Logger {
    private static final Controller controller = new Controller(new ConsoleSaver());

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public static void log(int ... message) {
        for (int value : message) {
            log(value);
            flush();
        }
    }

    public static void log(String  ... message) {
        for (String value : message) {
            log(value);
            flush();
        }
    }

    public static void flush() {
        controller.flush();
    }
}