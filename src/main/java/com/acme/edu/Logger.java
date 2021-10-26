package com.acme.edu;

import com.acme.edu.message.*;


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
        controller.log(new CharacterMessage(message));
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

    public static void log(int... message) {
        for (int simpleIntMessage : message) {
            log(simpleIntMessage);
        }
    }

    public static void log(String... message) {
        for (String simpleStringMessage : message) {
            log(simpleStringMessage);
        }
    }

    public static void log(int[][] message) {
        for (int[] intArray : message) {
            log(intArray);
        }
    }

    public static void flush() {
        controller.flush();
    }

}
