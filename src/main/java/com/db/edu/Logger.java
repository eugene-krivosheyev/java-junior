package com.db.edu;

import com.db.edu.message.*;
import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.FileSaver;

import java.io.File;

public class Logger {
    private static final Controller controller =
            new Controller(new FileSaver(new File("output.txt"), "utf8"));

    public static void log(int message) throws LoggerException {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) throws LoggerException {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) throws LoggerException {
        controller.log(new StringMessage(message));
    }

    public static void log(boolean message) throws LoggerException {
        controller.log(new BooleanMessage(message));
    }

    public static void log(char message) throws LoggerException {
        controller.log(new CharMessage(message));
    }

    public static void log(Object message) throws LoggerException {
        controller.log(new ObjectMessage(message));
    }

    public static void log(int ... message) throws LoggerException {
        for (int value : message) {
            log(value);
            flush();
        }
    }

    public static void log(String  ... message) throws LoggerException {
        for (String value : message) {
            log(value);
            flush();
        }
    }

    public static void flush() {
        controller.flush();
    }
}