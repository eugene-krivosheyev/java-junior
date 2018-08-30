package com.acme.edu;

import com.acme.edu.loggerexceptions.LoggerException;
import com.acme.edu.message.*;
import com.acme.edu.message.decorator.DefaultDecorator;

public class Logger {
    private static LoggerController controller = new LoggerController(new ConsoleLoggerSaver());

    public static int log(int message) {
        try {
            controller.log(new IntMessage(message, new DefaultDecorator("primitive")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int log(byte message) {
        try {
            controller.log(new ByteMessage(message, new DefaultDecorator("primitive")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int log(String message) {
        try {
            controller.log(new StringMessage(message, new DefaultDecorator("string")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int log(char message) {
        try {
            controller.log(new CharMessage(message, new DefaultDecorator("char")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int log(boolean message) {
        try {
            controller.log(new BoolMessage(message, new DefaultDecorator("primitive")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int log(Object message) {
        try {
            controller.log(new ReferenceMessage(message, new DefaultDecorator("reference")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int log(int[] message) {
        try {
            controller.log(new IntArrayMessage(message, new DefaultDecorator("primitives array")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int log(int[][] message) {
        try {
            controller.log(new Int2DimArrayMessage(message, new DefaultDecorator("primitives matrix")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int flush() {
        try {
            controller.log(new FlushMessage(new DefaultDecorator("")));
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    private Logger() {
    }
}
