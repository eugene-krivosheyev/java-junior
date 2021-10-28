package com.acme.edu;

import com.acme.edu.messages.*;

public class Logger {
    private static Printer printer = new Printer();
    private static Controller controller = new Controller(printer);
    private static Proxy proxy = new Proxy();

    public static void log(String... args) {
        for (String arg : args) {
            controller.log(new StringMessage(arg));
        }
    }

    public static void log(int... args) {
        for (int arg : args) {
            controller.log(new IntMessage(arg));
        }
    }

    public static void log(int[][] arr) {
        for (int[] args : arr) {
            for (int arg : args) {
                controller.log(new IntMessage(arg));
            }
        }
    }

    public static void log(int message) {
       // controller.log(new IntMessage(message));
        proxy.ProxyRequest(String.valueOf(message));
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
