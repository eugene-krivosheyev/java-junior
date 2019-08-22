package com.acme.edu;



public class Logger {

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String REFERENCE_PREFIX = "reference: ";

    private static enum Type {
        UNDEFINED,
        INTEGER,
        BYTE,
        BOOLEAN,
        CHAR,
        STRING,
        OBJECT
    }

    private static Type currentType = Type.UNDEFINED;

    private static String stringBuffer = null;
    private static int stringCounter = 0;

    private static long numberBuffer = 0;

    public static void log(String message) {
        flashAndChangeTypeIfNeeded(Type.STRING);
        accumulate(message);
    }

    public static void log(int message) {
        flashAndChangeTypeIfNeeded(Type.INTEGER);
        accumulate(message);
    }

    public static void log(byte message) {
        flashAndChangeTypeIfNeeded(Type.BYTE);
        accumulate(message);
    }

    public static void log(boolean message) {
        flashAndChangeTypeIfNeeded(Type.BOOLEAN);
        logPrimitive(String.valueOf(message));
    }

    public static void log(char message) {
        flashAndChangeTypeIfNeeded(Type.CHAR);
        logChar(String.valueOf(message));
    }

    public static void log(Object message) {
        flashAndChangeTypeIfNeeded(Type.OBJECT);
        logObject(String.valueOf(message));
    }

    private static void flashAndChangeTypeIfNeeded(Type type) {
        final boolean shouldTypeBeChanged = (type != currentType);
        if (shouldTypeBeChanged) {
            flush();
            currentType = type;
        }
    }

    public static void flush() {
        switch (currentType) {
            case UNDEFINED:
                break;
            case INTEGER:
            case BYTE:
                logPrimitive(String.valueOf(numberBuffer));
                numberBuffer = 0;
                break;
            case BOOLEAN:
                break;
            case CHAR:
                break;
            case STRING:
                if (stringBuffer == null) break;
                String message = stringBuffer;
                if (stringCounter > 1) {
                    message += " (x" + stringCounter + ")";
                }
                logString(message);
                stringBuffer = null;
                break;
            case OBJECT:
                break;
        }
    }

    private static void accumulate(String message) {
        if (stringBuffer == null) {
            stringBuffer = message;
            stringCounter = 1;
        } else if (stringBuffer.equals(message)) {
            stringCounter++;
        } else {
            flush();
            stringBuffer = message;
            stringCounter = 1;
        }
    }

    private static void accumulate(int number) {
        if (numberBuffer + number >= Integer.MAX_VALUE) {
            flush();
        }
        numberBuffer += number;
    }

    private static void accumulate(byte number) {
        if (numberBuffer + number >= Byte.MAX_VALUE) {
            flush();
        }
        numberBuffer += number;
    }

    // region Decorators
    private static String decoratePrimitive(String message) {
        return PRIMITIVE_PREFIX + message;
    }

    private static String decorateString(String message) {
        return STRING_PREFIX + message;
    }

    private static String decorateReference(String message) {
        return REFERENCE_PREFIX + message;
    }

    private static String decorateChar(String message) {
        return CHAR_PREFIX + message;
    }
    // endregion

    // region Loggers for each type
    private static void logPrimitive(String message) {
        Printer.print(decoratePrimitive(message));
    }

    private static void logChar(String message) {
        Printer.print(decorateChar(message));
    }

    private static void logString(String message) {
        Printer.print(decorateString(message));
    }

    private static void logObject(String message) {
        Printer.print(decorateReference(message));
    }
    // endregion
}
