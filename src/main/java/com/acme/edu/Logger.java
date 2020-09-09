package com.acme.edu;

import com.acme.edu.message.BoolMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {
    static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public static void main(String[] args) {
        loggerController.log(new IntMessage(12));
        loggerController.log(new IntMessage(12));
        loggerController.log(new StringMessage("Integer.MAX_VALUE"));
        loggerController.flush();
    }
    public static void flush() {
        loggerController.flush();
    }

    public static void log(int message) {
        loggerController.log(new IntMessage(message));
    }

    public static void log(byte message) {
        loggerController.log(message);
    }

    public static void log(int[] message) {
        loggerController.log((message));
    }

    public static void log(int[][] message) {
        loggerController.log(message);
    }

    public static void log(char message) {
        loggerController.log(message);
    }

    public static void log(String message) {
        loggerController.log(new StringMessage(message));
    }

    public static void log(Object message) {
        loggerController.log(message);
    }
}
