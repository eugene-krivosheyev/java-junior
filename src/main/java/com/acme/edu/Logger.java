package com.acme.edu;

import com.acme.edu.message.Message;

public class Logger {
    private static Controller controller = new Controller();
    private static MessageGenerator generator = new MessageGenerator();

    public static void log(int message) {
        controller.log(message);
    }

    public static void log(byte message) {
        controller.log(message);
    }

    public static void log(char message) {

    }

    public static void log(String message) {

    }

    public static void log(boolean message) {

    }

    public static void log(Object message) {

    }

    public static void log(int... message) {

    }

    public static void log(int[][] message) {

    }

    public static void flush() {
        controller.flush();
    }

}
