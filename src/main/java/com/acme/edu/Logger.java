package com.acme.edu;

import com.acme.edu.commands.*;

public class Logger {
    private static final SuperSaver saver = new ConsoleSaver();
    private static final LoggerController loggerController = new LoggerController(saver);

    public static void log(byte message) {
        Command command = new ByteCommand(message);
        loggerController.log(command);
    }

    public static void log(int message) {
        Command command = new IntCommand(message);
        loggerController.log(command);
    }

    public static void log(String message) {
        Command command = new StringCommand(message);
        loggerController.log(command);
        loggerController.flush();
    }

    public static void log(int[] array) {
//        flush();
        saver.save(Decorator.PR_ARRAY_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void log(int[][] array) {
//        flush();
        saver.save(Decorator.PR_MATRIX_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void log(Object message) {
//        flush();
        saver.save(Decorator.decorate(message));
    }

    public static void flush() {
        loggerController.flush();
    }
}
