package com.acme.edu;

import com.acme.edu.controller.Controller;
import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.*;

public class Logger {
    public static void flush() {
        controller.log(new FlushMessage());
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(int[] message) {
        controller.log(new IntArrayMessage(message));
    }

    public static void log(int[][] message) {
        controller.log(new IntMatrixMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ReferenceMessage(message));
    }

    public static void setDecorator(Decorator newDecorator) {
        controller.update(newDecorator);
    }

    private static Controller controller = new Controller();
}
