package com.acme.edu;

public class Logger {

    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";

    private static long state = 0;
    private static boolean integerSequence = false;

    public static void log(int message) {

       integerSequence = true;

        state = state + message;

        if (state >= Integer.MAX_VALUE) {
            state = state - Integer.MAX_VALUE;
            System.out.println(Integer.MAX_VALUE);
        }

        else if (state <= Integer.MIN_VALUE) {
            state = state + Integer.MIN_VALUE;
            System.out.println(Integer.MIN_VALUE);
        }

    }


    public static void log(byte message) {
        save(PRIMITIVE + message);
    }

    private static void save(String decoratedMessage) {
        if (integerSequence) {
            integerSequence = false;
            flush();
        }
        System.out.println(decoratedMessage);
    }

    public static void log(char message) {
        save(CHAR + message);
    }

    public static void log(String message) {
        save(STRING + message);
    }

    public static void log(boolean message) {
        save(PRIMITIVE + message);
    }

    public static void log(Object message) {
        save(REFERENCE + message);

    }

    public static void flush(){
        System.out.println(PRIMITIVE + state);
        state = 0;
    }

}
