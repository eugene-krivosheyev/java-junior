package com.acme.edu;


import com.acme.edu.commands.*;

public class Logger {

    private static LoggerController loggerController = new LoggerController();

    public static void flush() {
        loggerController.flush();
    }

    public static void log(String message) {
        loggerController.log(new StringCommand(message));
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
        for(String str : strings) {
            loggerController.log(new StringCommand(str));
        }
    }
}
