package com.acme.edu;

import com.acme.edu.controller.Controller;
import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.*;

public class Logger {
    public static int flush() {
        return controller.log(new FlushMessage());
    }

    public static int log(int message) {
        return controller.log(new IntMessage(message));
    }

    public static int log(int[] message) {
        return controller.log(new IntArrayMessage(message));
    }

    public static int log(int[][] message) {
        return controller.log(new IntMatrixMessage(message));
    }

    public static int log(byte message) {
        return controller.log(new ByteMessage(message));
    }

    public static int log(char message) {
        return controller.log(new CharMessage(message));
    }

    public static int log(String message) {
        return controller.log(new StringMessage(message));
    }

    public static int log(boolean message) {
        return controller.log(new BooleanMessage(message));
    }

    public static int log(Object message) {
        return controller.log(new ReferenceMessage(message));
    }

    public static void setDecorator(MessageType type, Decorator newDecorator) {
        controller.update(type, newDecorator);
    }

    private static Controller controller = new Controller(System.out::println);
}