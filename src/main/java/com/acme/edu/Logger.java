package com.acme.edu;

import com.acme.edu.Decorator.Decorator;
import com.acme.edu.controller.Controller;
import com.acme.edu.message.*;

import static com.acme.edu.Decorator.IntegerDecorator.INTEGER;

public class Logger {

    private static Controller controller = new Controller();

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(int message, Decorator decorator) {
        controller.log(new IntMessage(message,
                (Message elem) -> INTEGER + ((IntMessage) elem).getValue())
        );
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public static void flush() {
        controller.flush();
    }
}


