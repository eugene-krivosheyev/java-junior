package com.acme.edu;


import com.acme.edu.commands.*;

import java.io.IOException;

public class Logger {

    //private java.util.logging.Logger jul = new java.util.logging.Logger();

    private static LoggerController loggerController = new LoggerController();

    public static void flush() {
        loggerController.flush();
    }

    public static void log(String message) throws IOException {
        // TODO
        try {
            loggerController.log(new StringCommand(message));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Operation was not done");
        }
    }

    public static void log(int message) {
        loggerController.log(new IntCommand(message));
    }

    public static void log(byte message) {
        loggerController.log(new ByteCommand(message));
    }

    public static void log(boolean message) {
        loggerController.log(new BooleanCommand(message));
    }

    public static void log(int[] array) {
        loggerController.log(new IntArrayCommand((array)));
    }

    public static void log(String... strings) {
        for (String str : strings) {
            loggerController.log(new StringCommand(str));
        }
    }
}
