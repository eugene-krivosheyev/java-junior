package com.acme.edu;

import com.acme.edu.processors.*;

public class Logger {

    public static void log(String... args) {
        for (String arg : args) {
            Controller.log(new StringMessage(arg));
        }
    }

    public static void log(int... args) {
        for (int arg : args) {
            Controller.log(new IntMessage(arg));
        }
    }

    public static void log(int[][] arr) {
        for (int[] args : arr) {
            for (int arg : args) {
                Controller.log(new IntMessage(arg));
            }
        }
    }

    public static void log(int message) {
        Controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        Controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        Controller.log(new CharMessage(message));
    }

    public static void log(String message) {
        Controller.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        Controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        Controller.log(new ObjectMessage(message));
    }

    public static void flush() {
        Controller.flush();
    }

}
