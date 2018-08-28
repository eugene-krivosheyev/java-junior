package com.acme.edu;

import com.acme.edu.controller.LogController;
import com.acme.edu.message.decorator.PrefixLoggerDecorator;
import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleLoggerSaver;

public final class Logger {
    private Logger(){}

    private static LogController controller = new LogController(new ConsoleLoggerSaver(), new PrefixLoggerDecorator());

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void setController(LogController controller) {
        Logger.controller = controller;
    }

    public  static void flush(){
        controller.flush();
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(int ... message) {
        controller.log(new ArrayIntMessage(message));
    }

    public static void log(int [] ... message) {
        controller.log(new MatrixIntMessage(message));
    }
}
