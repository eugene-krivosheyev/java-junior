package com.acme.edu;

public class Logger {
    public static void log(int message) {
        log(Integer.valueOf(message));
    }

    public static void log(byte message) {
        log(Byte.valueOf(message));
    }

    public static void log(char message) {
        log(Character.valueOf(message));
    }

    public static void log(boolean message) {
        log(Boolean.valueOf(message));
    }

    public static void log(Object message) {

        String prefix;

        if ( message instanceof Integer ||
             message instanceof Byte    ||
             message instanceof Boolean     ) {
            prefix = "primitive: ";
        } else if ( message instanceof String ) {
            prefix = "string: ";
        } else if ( message instanceof Character ) {
            prefix = "char: ";
        } else {
            prefix = "reference: ";
        }

        System.out.print(prefix + message + "\n");
    }
}

