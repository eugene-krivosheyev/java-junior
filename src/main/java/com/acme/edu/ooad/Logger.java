package com.acme.edu.ooad;

import com.acme.edu.ooad.controller.LoggerController;
import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.ConsoleSaver;
import com.acme.edu.ooad.saver.Saver;

public class Logger {
    private static final LoggerController controller = new LoggerController(new ConsoleSaver());

    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.log(new IntegerMessage(message));
    }

    public static void log(int... integers) {
        for ( var integer: integers ) {
            controller.log(new IntegerMessage(integer));
        }
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(String... strings) {
        for ( var string : strings ) {
            controller.log(new StringMessage(string));
        }
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }
}
