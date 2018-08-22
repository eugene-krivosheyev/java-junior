package com.acme.edu;


public class Logger {
    public static void log(int message) /* throws Exception */ {
        String decoratedMessage = PRIMITIVE + message;
        if (message >= 0) {
            if (currentSum + message < currentSum) {
                Logger.flush();
            }
        }
        else {
            if (currentSum + message > currentSum) {
                Logger.flush();
            }
        }
        currentSum += message;
        checkStare(State.INTEGER);
        save(decoratedMessage);
        currentState = State.INTEGER;
    }

    public static void log(byte message) /* throws Exception */ {
        String decoratedMessage = PRIMITIVE + message;
        if (message >= 0) {
            if ((byte)currentSum + (byte)message < (byte)currentSum) {
                Logger.flush();
            }
        }
        else {
            if ((byte)currentSum + (byte)message > (byte)currentSum) {
                Logger.flush();
            }
        }
        currentSum += message;
        checkStare(State.BYTE);
        save(decoratedMessage);
        currentState = State.BYTE;
    }

    public static void log(char message) /* throws Exception */{
        String decoratedMessage = CHAR + message;
        checkStare(State.STRING);
        save(decoratedMessage);
        currentState = State.STRING;
    }

    public static void log(String message) /* throws Exception */ {
        String decoratedMessage = STRING + message;
        if (message.equals(currentString)) {
            currentStringCount += 1;
        }
        else {
            currentStringCount = 1;
            currentString = message;
        }
        checkStare(State.STRING);
        save(decoratedMessage);
        currentState = State.STRING;
    }

    public static void log(boolean message) /* throws Exception */ {
        String decoratedMessage = PRIMITIVE + message;
        checkStare(State.INTEGER);
        save(decoratedMessage);
        currentState = State.INTEGER;
    }

    public static void log(Object message) /* throws Exception */ {
        String decoratedMessage = REFERENCE + message;
        checkStare(State.REFERENCE);
        save(decoratedMessage);
        currentState = State.REFERENCE;
    }

    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";


    public enum State { INITIAL, INTEGER, BYTE, STRING, REFERENCE}

    private static State currentState = State.INITIAL;
    private static int currentSum = 0;
    private static String currentString = null;
    private static int currentStringCount = 0;

    private static void save(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    private static void checkStare(State state) /* throws Exception */ {
        if (state != currentState && state != State.INITIAL) {
            Logger.flush();
        }
    }

    public static void flush() /* throws Exception */ {
        switch (currentState) {
            /*case INITIAL:
                throw new Exception("1"); */
            case INTEGER:
                save(currentSum + "");
                currentSum = 0;
                break;
            case BYTE:
                save(currentSum + "");
                currentSum = 0;
                break;
            case STRING:
                if (currentStringCount == 1) {
                    save(currentString);
                }
                else {
                    save (currentString + " (x" + currentStringCount + ")");
                }
                currentStringCount = 0;
                break;
        }
        //System.out.println(decoratedMessage);
    }

}
