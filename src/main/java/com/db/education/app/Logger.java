package com.db.education.app;

import com.db.education.app.controller.LoggerController;
import com.db.education.app.exception.LogException;
import com.db.education.app.exception.SaveException;
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
        try {
            loggerController.accept(new IntegerMessage(message));
        } catch (LogException e) {
            System.out.println("Log failed: " + e.getMessage());
            e.printStackTrace();
        } catch (SaveException e) {
            System.out.println("Saving failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void log(byte message) {
        try {
            loggerController.accept(new ByteMessage(message));
        } catch (LogException e) {
            System.out.println("Log failed: " + e.getMessage());
            e.printStackTrace();
        } catch (SaveException e) {
            System.out.println("Saving failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void log(char message) {
        try {
            loggerController.accept(new CharacterMessage(message));
        } catch (LogException e) {
            System.out.println("Log failed: " + e.getMessage());
            e.printStackTrace();
        } catch (SaveException e) {
            System.out.println("Saving failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void log(boolean message) {
        try {
            loggerController.accept(new BooleanMessage(message));
        } catch (LogException e) {
            System.out.println("Log failed: " + e.getMessage());
            e.printStackTrace();
        } catch (SaveException e) {
            System.out.println("Saving failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        try {
            loggerController.accept(new StringMessage(message));
        } catch (LogException e) {
            System.out.println("Log failed: " + e.getMessage());
            e.printStackTrace();
        } catch (SaveException e) {
            System.out.println("Saving failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void log(Object message) {
        try {
            loggerController.accept(new ObjectMessage(message));
        } catch (LogException e) {
            System.out.println("Log failed: " + e.getMessage());
            e.printStackTrace();
        } catch (SaveException e) {
            System.out.println("Saving failed: " + e.getMessage());
            e.printStackTrace();
        }
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
        try {
            loggerController.flush();
        } catch (SaveException e) {
            System.out.println("Saving failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
