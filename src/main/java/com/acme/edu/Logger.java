package com.acme.edu;

import com.acme.edu.controller.Controller;
import com.acme.edu.message.*;
import com.acme.edu.saver.Saver;

public class Logger {

    private static final Controller controller = new Controller(new Saver());

    public static void log(int... message) {
        for (int i : message) {
            controller.log(new ArrayNumberMessage(Integer.MAX_VALUE, Integer.MIN_VALUE, i));
        }
    }

    public static void log(int[][] message) {

    }

    public static void log(String... message) {
        for (String str : message) {
            log(str);
        }
    }

    public static void log(int message) {
        controller.log(new SingleNumberMessage(Integer.MAX_VALUE, Integer.MIN_VALUE, message));
    }

    public static void log(byte message) {
        controller.log(new SingleNumberMessage(Byte.MAX_VALUE, Byte.MIN_VALUE, message));
    }

    public static void flush() {
        controller.flush();
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ReferenceMessage(message));
    }


}
