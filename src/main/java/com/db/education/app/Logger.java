package com.db.education.app;

import com.db.education.app.controller.LoggerController;
import com.db.education.app.message.*;
import com.db.education.app.saver.ConsoleSaver;

/**
 * Logger logs provided messages into console with accumulation and decoration based on message type.
 *
 * Logger's way of storing messages (such as file, database, etc.) can be extended
 * by the provision of a class, implementing the Saver interface, to the LoggerController.
 *
 * Logger is a pure static class and shouldn't be instantiated.
 *
 * Logger consist of two methods:
 * - overloaded log() method for automatic processing and storing of different types of parameters
 * for a proper accumulation and decoration.
 * - flush() method, that should be called whenever accumulated log should actually be saved.
 */
public class Logger {

    private static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    private Logger() {
    }

    public static void log(int message) {
        loggerController.accept(new IntegerMessage(message));
    }

    public static void log(byte message) {
        loggerController.accept(new ByteMessage(message));
    }

    public static void log(char message) {
        loggerController.accept(new CharacterMessage(message));
    }

    public static void log(boolean message) {
        loggerController.accept(new BooleanMessage(message));
    }

    public static void log(String message) {
        loggerController.accept(new StringMessage(message));
    }

    public static void log(Object message) {
        loggerController.accept(new ObjectMessage(message));
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
