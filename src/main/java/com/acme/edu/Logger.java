package com.acme.edu;

import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntegerMessage;
import com.acme.edu.message.StringMessage;

public class Logger {
    private static final Saver saver = new Saver();
    private static final Controller controller = new Controller(saver);

    public static void log(int message) {
        controller.log(new IntegerMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) {

    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
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
