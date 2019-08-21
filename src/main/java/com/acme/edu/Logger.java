package com.acme.edu;

/**
 * JavaDoc comment
 * Class Logger has unnecessarily comment.
 * <strong>bold</strong>
 *
 * @see java.lang.String#String()
 */
public class Logger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String OBJECT_PREFIX = "reference: ";

    public static void log(int message) {
        decoratePrimitive(String.valueOf(message));
    }

    public static void log(byte message) {
        decoratePrimitive(String.valueOf(message));
    }

    public static void log(boolean message) {
        decoratePrimitive(String.valueOf(message));
    }

    public static void log(char message) {
        save(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        save(STRING_PREFIX + message);
    }

    public static void log(Object message) {
        save(OBJECT_PREFIX + message);
    }

    private static void decoratePrimitive(String message) {
        save(PRIMITIVE_PREFIX + message);
    }

    private static void save(String message) {
        System.out.print(message + System.lineSeparator());
    }
}