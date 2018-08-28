package com.acme.edu;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.decorator.PrefixDecorator;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.FlushMessage;

public class Logger {
    private static LoggerController loggerController = new LoggerController();
    public static void log(int message) throws Exception {
        loggerController.log(new IntMessage(message, new PrefixDecorator()));
    }
    public static void log(String message) throws Exception {
        loggerController.log(new StringMessage(message, new PrefixDecorator()));
    }
    public static void flush() throws Exception {
        loggerController.log(new FlushMessage(new PrefixDecorator()));
    }
}
