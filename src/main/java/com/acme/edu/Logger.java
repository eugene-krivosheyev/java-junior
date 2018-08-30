package com.acme.edu;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.loggerexceptions.LoggerException;
import com.acme.edu.message.*;
import com.acme.edu.message.decorator.DefaultDecorator;

public class Logger {
    private static LoggerController controller = new LoggerController(new ConsoleLoggerSaver());

    private static int log (Message message) {
        try {
            controller.log(message);
        } catch (LoggerException e) {
            return e.getErrorCodeOrdinal();
        }
        return 0;
    }

    public static int log(int message) throws LoggerDecoratorException {
        return log(new IntMessage(message, new DefaultDecorator("primitive")));
    }

    public static int log(byte message) throws LoggerDecoratorException {
        return log(new ByteMessage(message, new DefaultDecorator("primitive")));
    }

    public static int log(String message) throws LoggerDecoratorException {
        return log(new StringMessage(message, new DefaultDecorator("string")));
    }

    public static int log(char message) throws LoggerDecoratorException {
        return log(new CharMessage(message, new DefaultDecorator("char")));
    }

    public static int log(boolean message) throws LoggerDecoratorException {
        return log(new BoolMessage(message, new DefaultDecorator("primitive")));
    }

    public static int log(Object message) throws LoggerDecoratorException {
        return log(new ReferenceMessage(message, new DefaultDecorator("reference")));
    }

    public static int log(int[] message) throws LoggerDecoratorException {
        return log(new IntArrayMessage(message, new DefaultDecorator("primitives array")));
    }

    public static int log(int[][] message) throws LoggerDecoratorException {
        return log(new Int2DimArrayMessage(message, new DefaultDecorator("primitives matrix")));
    }

    public static int flush() throws LoggerDecoratorException {
        return log(new FlushMessage(new DefaultDecorator("")));
    }

    private Logger() {
    }
}
