package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {
    static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public static void flush() {
        loggerController.flush();
    }

    public static void log(int message) {
        loggerController.log(new IntMessage(message));
    }

    public static void log(byte message) {
        loggerController.log(new ByteMessage(message));
    }

    public static void log(int[] message) {
        loggerController.log(new ArrayMessage(message));
    }

    public static void log(String message) {
        loggerController.log(new StringMessage(message));
    }

    public static void log(boolean message) { loggerController.log(new BoolMessage(message));}
}
