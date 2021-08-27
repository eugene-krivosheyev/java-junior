package com.db.education.app;

import com.db.education.app.controller.LoggerController;
import com.db.education.app.message.*;
import com.db.education.app.saver.ConsoleSaver;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    private Logger() {
    }

    public static void log(int message) {
        loggerController.processMessage(new IntegerMessage(message));
    }

    public static void log(byte message) {
        loggerController.processMessage(new ByteMessage(message));
    }

    public static void log(char message) {
        loggerController.processMessage(new CharacterMessage(message));
    }

    public static void log(boolean message) {
        loggerController.processMessage(new BooleanMessage(message));
    }

    public static void log(String message) {
        loggerController.processMessage(new StringMessage(message));
    }

    public static void log(Object message) {
        loggerController.processMessage(new ObjectMessage(message));
    }

    public static void log(int... messages) {
        for (int message : messages) {
            log(message);
        }
    }

    public static void log(String... messages) {
        for (String message : messages) {
            log(message);
        }
    }

    public static void flush() {
        loggerController.flush();
    }
}
