package com.acme.edu;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.FlushMessage;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void log(int message) {
        loggerController.log(new IntMessage(message));
    }
    public static void log(String message) {
        loggerController.log(new StringMessage(message));
    }
    public static void flush() {
        loggerController.log(new FlushMessage());
    }
}
