package com.acme.edu;

public class Logger {
    public static void log(int message) {
        Integer i = message;
        log(i);
    }

    public static void log(byte message) {
        Byte b = message;
        log(b);
    }

    public static void log(char message) {
        Character c = message;
        log(c);
    }

    public static void log(boolean message) {
        Boolean b = message;
        log(b);
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

