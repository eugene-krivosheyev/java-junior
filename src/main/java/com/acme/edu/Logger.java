package com.acme.edu;

import com.acme.edu.message.BoolMessage;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {
    static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public static void flush() {
        loggerController.flush();
    }

    public static void log(int message) {
        loggerController.log(message);
    }

    public static void log(byte message) {
        loggerController.log(message);
    }

    public static void log(int[] message) {
        loggerController.log(message);
    }

    public static void log(int[][] message) {
        loggerController.log(message);
    }

    public static void log(char message) {
        loggerController.log(message);
    }

    public static void log(String message) {
        loggerController.log(message);
    }

    public static void log(boolean message) {
        loggerController.log( new BoolMessage(message) );
    }

    public static void log(Object message) {
        loggerController.log(message);
    }
}
