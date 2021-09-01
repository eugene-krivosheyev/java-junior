package com.db.edu;

import com.db.edu.messagepack.message.*;
import com.db.edu.saver.FileSaver;

public class Logger {
    private static FileSaver fileSaver = new FileSaver();
    private static Controller controller = new Controller(fileSaver);

    private Logger() {
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
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

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public static void log(int... message) {
        for (int current : message) {
            controller.log(new IntMessage(current));
        }
    }

    public static void log(String... message) {
        for (String current : message) {
            controller.log(new StringMessage(current));
        }
    }

    public static void flush() {
        controller.flush();
    }
}