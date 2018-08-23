package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE_PREFIX = "primitive";
    private static final String CHAR_PREFIX = "char";
    private static final String STRING_PREFIX = "string";
    private static final String REFERENCE_PREFIX = "reference";
    private static final String ARRAY_PREFIX = "primitives array";
    private static final String MATRIX_PREFIX = "primitives matrix";
    private static final String SEPARATOR = ": ";

    private static State currentState = State.INITIAL;
    private static String previousString = null;
    private static int stringNumberOccurrences = 0;
    private static int sequenceSum = 0;

    public static void log(int message) {
        if (currentState != State.INT) {
            flush();
        }
        currentState = State.INT;
        if (isTypeOverflowed(sequenceSum, message, State.INT)) {
            flush();
        }
        sequenceSum += message;
        String decoratedMessage = PRIMITIVE_PREFIX + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(byte message) {
        if (currentState != State.BYTE) {
            flush();
        }
        currentState = State.BYTE;
        if (isTypeOverflowed(sequenceSum, message, State.BYTE)) {
            flush();
        }
        sequenceSum += message;
        String decoratedMessage = PRIMITIVE_PREFIX + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(String message) {
        if (currentState != State.STRING) {
            flush();
        }
        currentState = State.STRING;
        if (!message.equals(previousString)) {
            flush();
            previousString = message;
            stringNumberOccurrences = 1;
        }
        else {
            stringNumberOccurrences++;
        }
    }

    public static void log(char message) {
        currentState = State.CHAR;
        String decoratedMessage = CHAR_PREFIX + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(boolean message) {
        currentState = State.BOOLEAN;
        String decoratedMessage = PRIMITIVE_PREFIX + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(Object message) {
        currentState = State.OBJECT;
        String decoratedMessage = REFERENCE_PREFIX + SEPARATOR + message;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(int[] message) {
        currentState = State.INT_ARRAY;
        StringBuilder arrayAsString = buildArrayAsString(message);
        String decoratedMessage = ARRAY_PREFIX + SEPARATOR + arrayAsString;
        saveDecoratedMessage(decoratedMessage);
    }

    public static void log(int[][] message) {
        currentState = State.INT_ARRAY_2D;
        StringBuilder array2DAsString = new StringBuilder();
        array2DAsString.append("{").append(System.lineSeparator());
        for (int currentIndex = 0; currentIndex < message.length; ++currentIndex) {
            array2DAsString.append(buildArrayAsString(message[currentIndex])).append(System.lineSeparator());
        }
        array2DAsString.append("}").append(System.lineSeparator());
        String decoratedMessage = MATRIX_PREFIX + SEPARATOR + array2DAsString;
        saveDecoratedMessage(decoratedMessage);
    }

    private static StringBuilder buildArrayAsString(int[] array) {
        StringBuilder arrayAsString = new StringBuilder();
        arrayAsString.append("{");
        for (int currentIndex = 0; currentIndex < array.length; ++currentIndex) {
            if (currentIndex < array.length - 1) {
                arrayAsString.append(array[currentIndex]).append(", ");
            } else {
                arrayAsString.append(array[currentIndex]);
            }
        }
        arrayAsString.append("}");
        return arrayAsString;
    }

    private static boolean isTypeOverflowed(int currentSum, int newNumber, State type) {

        if (State.INT.equals(type)) {
            return currentSum > 0
                    ? Integer.MAX_VALUE - currentSum < newNumber
                    : Integer.MIN_VALUE - currentSum > newNumber;
        }
        if (State.BYTE.equals(type)) {
            return currentSum > 0
                    ? Byte.MAX_VALUE - currentSum < newNumber
                    : Byte.MIN_VALUE - currentSum > newNumber;
        }
        return false;
    }

    public static void flush() {
        if (State.STRING.equals(currentState)) {
            if (stringNumberOccurrences > 1) {
                saveDecoratedMessage(STRING_PREFIX + SEPARATOR + previousString +
                        " (x" + stringNumberOccurrences + ")");
                stringNumberOccurrences = 0;

            } else {
                saveDecoratedMessage(STRING_PREFIX + SEPARATOR + previousString);
                stringNumberOccurrences = 0;
            }
        }
        if (State.INT.equals(currentState)) {
            saveDecoratedMessage(String.valueOf(sequenceSum));
            sequenceSum = 0;
        }
        if (State.BYTE.equals(currentState)) {
            saveDecoratedMessage(String.valueOf(sequenceSum));
            sequenceSum = 0;
        }
        return;
    }

    private static void saveDecoratedMessage(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
