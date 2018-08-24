package com.acme.edu;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    private final String PRIMITIVE_PREFIX = "primitive";
    private final String CHAR_PREFIX = "char";
    private final String STRING_PREFIX = "string";
    private final String REFERENCE_PREFIX = "reference";
    private final String ARRAY_PREFIX = "primitives array";
    private final String MATRIX_PREFIX = "primitives matrix";
    private final String SEPARATOR = ": ";

    private State currentState = State.INITIAL;
    private String previousString = null;
    private int stringNumberOccurrences = 0;
    private int sequenceSum = 0;

    public static void flush() {
        loggerController.flush();
    }

    public static void log(int message) {
        Message currentIntMessage = new IntMessage(message);
        loggerController.log(currentIntMessage);

//        if (currentState != State.INT) {
//            flush();
//        }
//        currentState = State.INT;
//        if (isTypeOverflowed(sequenceSum, message, currentState)) {
//            flush();
//        }
//        sequenceSum += message;
//        String decoratedMessage = PRIMITIVE_PREFIX + SEPARATOR + message;
//        saveDecoratedMessage(decoratedMessage);
    }

//     public static void log(byte message) {
//        if (currentState != State.BYTE) {
//            flush();
//        }
//        currentState = State.BYTE;
//        if (isTypeOverflowed(sequenceSum, message, currentState)) {
//            flush();
//        }
//        sequenceSum += message;
//        String decoratedMessage = PRIMITIVE_PREFIX + SEPARATOR + message;
//        saveDecoratedMessage(decoratedMessage);
//    }
//
//     public static void log(String message) {
//        if (currentState != State.STRING) {
//            flush();
//        }
//        currentState = State.STRING;
//        if (!message.equals(previousString)) {
//            flush();
//            previousString = message;
//            stringNumberOccurrences = 1;
//        }
//        else {
//            stringNumberOccurrences++;
//        }
//    }
//
//     public static void log(char message) {
//        currentState = State.CHAR;
//        String decoratedMessage = CHAR_PREFIX + SEPARATOR + message;
//        saveDecoratedMessage(decoratedMessage);
//    }
//
//     public static void log(boolean message) {
//        currentState = State.BOOLEAN;
//        String decoratedMessage = PRIMITIVE_PREFIX + SEPARATOR + message;
//        saveDecoratedMessage(decoratedMessage);
//    }
//
//     public static void log(Object message) {
//        currentState = State.OBJECT;
//        String decoratedMessage = REFERENCE_PREFIX + SEPARATOR + message;
//        saveDecoratedMessage(decoratedMessage);
//    }
//
//     public static void log(int[] message) {
//        currentState = State.INT_ARRAY;
//        StringBuilder arrayAsString = buildArrayAsString(message);
//        String decoratedMessage = ARRAY_PREFIX + SEPARATOR + arrayAsString;
//        saveDecoratedMessage(decoratedMessage);
//    }
//
//     public static void log(int[][] message) {
//        currentState = State.INT_ARRAY_2D;
//        StringBuilder array2DAsString = buildArrayAsString(message);
//        String decoratedMessage = MATRIX_PREFIX + SEPARATOR + array2DAsString;
//        saveDecoratedMessage(decoratedMessage);
//    }
//
//    private StringBuilder buildArrayAsString(int[] array) {
//        StringBuilder arrayAsString = new StringBuilder();
//        arrayAsString.append("{");
//        for (int currentIndex = 0; currentIndex < array.length; ++currentIndex) {
//            if (currentIndex < array.length - 1) {
//                arrayAsString.append(array[currentIndex]).append(", ");
//            } else {
//                arrayAsString.append(array[currentIndex]);
//            }
//        }
//        arrayAsString.append("}");
//        return arrayAsString;
//    }
//
//    private StringBuilder buildArrayAsString(int[][] array) {
//        StringBuilder array2DAsString = new StringBuilder();
//        array2DAsString.append("{").append(System.lineSeparator());
//        for (int currentIndex = 0; currentIndex < array.length; ++currentIndex) {
//            array2DAsString.append(buildArrayAsString(array[currentIndex])).append(System.lineSeparator());
//        }
//        array2DAsString.append("}").append(System.lineSeparator());
//        return  array2DAsString;
//    }
//
//    private boolean isTypeOverflowed(int currentSum, int newNumber, State type) {
//        if (State.INT.equals(type)) {
//            return currentSum > 0
//                    ? Integer.MAX_VALUE - currentSum < newNumber
//                    : Integer.MIN_VALUE - currentSum > newNumber;
//        }
//        if (State.BYTE.equals(type)) {
//            return currentSum > 0
//                    ? Byte.MAX_VALUE - currentSum < newNumber
//                    : Byte.MIN_VALUE - currentSum > newNumber;
//        }
//        return false;
//    }
//
//    public void flush() {
//        if (State.STRING.equals(currentState)) {
//            if (stringNumberOccurrences > 1) {
//                saveDecoratedMessage(STRING_PREFIX + SEPARATOR + previousString +
//                        " (x" + stringNumberOccurrences + ")");
//                stringNumberOccurrences = 0;
//
//            } else {
//                saveDecoratedMessage(STRING_PREFIX + SEPARATOR + previousString);
//                stringNumberOccurrences = 0;
//            }
//        }
//        if (State.INT.equals(currentState)) {
//            saveDecoratedMessage(String.valueOf(sequenceSum));
//            sequenceSum = 0;
//        }
//        if (State.BYTE.equals(currentState)) {
//            saveDecoratedMessage(String.valueOf(sequenceSum));
//            sequenceSum = 0;
//        }
//        return;
//    }
//
//    private void saveDecoratedMessage(String decoratedMessage) {
//        System.out.println(decoratedMessage);
//    }
}