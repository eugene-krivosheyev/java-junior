package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.message.decorator.DefaultDecorator;

public class Logger {
    private static LoggerController controller = new LoggerController(new ConsoleLoggerSaver());

    public static void log(int message) {
        controller.log(new IntMessage(message, new DefaultDecorator("primitive")));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message, new DefaultDecorator("primitive")));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message, new DefaultDecorator("string")));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message, new DefaultDecorator("char")));
    }

    public static void log(boolean message) {
        controller.log(new BoolMessage(message, new DefaultDecorator("primitive")));
    }

    public static void log(Object message) {
        controller.log(new ReferenceMessage(message, new DefaultDecorator("reference")));
    }

    public static void log(int [] message) {
        controller.log(new IntArrayMessage(message, new DefaultDecorator("primitives array")));
    }

    public static void log(int [][] message) {
        controller.log(new Int2DimArrayMessage(message, new DefaultDecorator("primitives matrix")));
    }
    public static void flush() {
        controller.log(new FlushMessage(new DefaultDecorator("")));
    }

    private Logger() {}
}
