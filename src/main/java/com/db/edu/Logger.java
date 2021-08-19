package com.db.edu;


public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";

    public static void log(Object message) {
        String prefix;
        if (message instanceof Integer || message instanceof Byte || message instanceof Boolean) {
            prefix = PRIMITIVE_PREFIX;
        }
        else if (message instanceof Character) {
            prefix = CHAR_PREFIX;
        }
        else if (message instanceof String) {
            prefix = STRING_PREFIX;
        }
        else {
            prefix = OBJECT_PREFIX;
        }
        writeMessage(prefix + message);
    }

    private static void writeMessage(String s) {
        System.out.println(s);
    }
}