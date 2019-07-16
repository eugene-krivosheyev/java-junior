package com.acme.edu;

public class Logger {
    private static String currentState = null;
    private static int intState = 0;
    private static byte byteState = 0;

    public static void log(int message) {
        log("int", () -> intState = message);
        intState += message;
    }

    public static void log(byte message) {
        log("byte", () -> byteState = message);
        byteState += message;
    }

    private static void log(String state, SideEffect todo) {
        if (!state.equals(currentState)) {
            flush();
            todo.apply();
            currentState = state;
            return;
        }
    }

    private static void flush() {

    }
}

@FunctionalInterface
interface SideEffect {
    void apply();
}
