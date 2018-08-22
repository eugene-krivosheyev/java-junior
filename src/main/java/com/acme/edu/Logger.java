package com.acme.edu;

import java.util.ArrayList;
import java.util.HashMap;

public class Logger {
    private static final String PRIMITIVE = "primitive";
    private static final String CHAR = "char";
    private static final String STRING = "string";
    private static final String REFERENCE = "reference";
    private static final String SEPARATOR = ": ";

    private static int sum = 0;
    private static HashMap<String, Integer> stringCounter = new HashMap<>();

    public static void log(int message) {
        sum += message;
//        arrayToSum.add(message);
        //String decoratedMessage = PRIMITIVE + SEPARATOR + message;
        //saveDecoratedMessage(decoratedMessage);
    }

    public static void log(byte message) {
        sum += message;
        String decoratedMessage = PRIMITIVE + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(char message) {
        String decoratedMessage = CHAR + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(String message) {
        String decoratedMessage = STRING + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(boolean message) {
        String decoratedMessage = PRIMITIVE + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(Object message) {
        String decoratedMessage = REFERENCE + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    private static void saveDecoratedMessage(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    public static void digitFlush() {
        String decoratedMessage = sum + System.lineSeparator();
        sum = 0;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void stringFlush() {
        for(String currentString : stringCounter.keySet()) {
            String decoratedMessage = "";
            if (stringCounter.get(currentString) > 1) {
                 decoratedMessage = currentString + "(" + "x" + stringCounter.get(currentString) + ")" + System.lineSeparator();
            } else {
                decoratedMessage = currentString;
            }
            saveDecoratedMessage(decoratedMessage);
        }
        stringCounter.clear();
    }

}
