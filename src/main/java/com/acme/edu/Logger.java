package com.acme.edu;

import com.acme.edu.controller.Controller;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;

public class Logger {

    private static final Controller controller = new Controller();

    public static void log(int... message) {
    }

    public static void log(int[][] message) {
    }

    public static void log(String... message) {
        for (String str : message) {
            log(str);
        }
    }

    public static void log(int message) {
        controller.perform(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.perform(new ByteMessage(message));
    }

    public static void flush() {
        controller.flush();
    }

    public static void log(String message) {
        controller.perform(new StringMessage(message));
    }

    public static void log(char message) {
    }

    public static void log(boolean message) {
    }

    public static void log(Object message) {
    }


}
