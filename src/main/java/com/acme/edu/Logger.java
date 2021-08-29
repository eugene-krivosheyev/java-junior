package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;

import java.util.Arrays;


public class Logger {
    private static final LoggerController controller = new LoggerController(new ConsoleSaver());

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(int... messages) {
        Arrays.stream(messages).forEach(Logger::log);
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

    public static void log(String... messages) {
        Arrays.stream(messages).forEach(Logger::log);
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ReferenceMessage(message));
    }

    public static void flush() {
        controller.flush();
    }
}
