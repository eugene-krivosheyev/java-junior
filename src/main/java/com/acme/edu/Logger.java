package com.acme.edu;

import com.acme.edu.controller.Controller;
import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {

    private static final Controller controller = new Controller(new ConsoleSaver());

    private static void arrayLog(int message) {
        controller.log(new ArrayNumberMessage(Integer.MAX_VALUE, Integer.MIN_VALUE, message));
    }

    public static void log(int... message) {
        for (int i : message) {
            arrayLog(i);
        }
    }

    public static void log(int[][] message) {
        for (int[] arr : message) {
            log(arr);
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

    public static void log(String... message) {
        for (String str : message) {
            log(str);
        }
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
