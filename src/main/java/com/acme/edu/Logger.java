package com.acme.edu;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.decorator.PrefixDecorator;
import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;

public class Logger {
    private static LoggerController loggerController;
    private static Decorator decorator;
    private static Saver saver;
    public Logger(Message message, Saver saver, Decorator decorator) {
        this.decorator = decorator;
        message.setSaver(saver);
        loggerController = new LoggerController(message, saver, decorator);
    }
    public static void log(int message) throws Exception {
        loggerController.log(new IntMessage(message, saver, decorator));
    }
    public static void log(String message) throws Exception {
        loggerController.log(new StringMessage(message, saver, decorator));
    }
    public static void log(byte message) throws Exception {
        loggerController.log(new ByteMessage(message, saver, decorator));
    }
    public static void log(char message) throws Exception {
        loggerController.log(new CharMessage(message, saver, decorator));
    }
    public static void flush() throws Exception {
        loggerController.log(new FlushMessage(saver, decorator));
    }
    public static void log(boolean message) throws Exception {
        loggerController.log(new BoolMessage(message, saver, decorator));
    }
}
