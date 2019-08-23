package com.acme.edu;


import static com.acme.edu.Buffer.*;
import static com.acme.edu.Decorator.decorateArray;
import static com.acme.edu.Decorator.decorateString;
import static com.acme.edu.Saver.printToConsole;

public class Logger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    private static final String PRIMITIVE_PREFIX_FOR_ARRAY = "primitives array: ";
    private static final String PRIMITIVE_PREFIX_FOR_MATRIX = "primitives matrix: ";
    private static final String PRIMITIVE_PREFIX_FOR_MULTI_MATRIX = "primitives multimatrix: ";

    public static void log(Object message) { printToConsole(decorateString(REFERENCE_PREFIX, message)); }

    public static void log(char message) { printToConsole(decorateString(CHAR_PREFIX, message)); }

    public static void log(boolean message) { printToConsole(decorateString(PRIMITIVE_PREFIX, message)); }

    public static void log(byte message) {
        changeState(BufferState.BYTE);
        addInBuffer(message);
        printToConsole(decorateString(PRIMITIVE_PREFIX, message));
    }

    public static void log(int message) {
        changeState(BufferState.INT);
        addInBuffer(message);
        printToConsole(decorateString(PRIMITIVE_PREFIX, message));
    }

    public static void log(String message) {
        changeState(BufferState.STR);
        addInBuffer(message);
        printToConsole(decorateString(STRING_PREFIX, message));
    }

    public static void log(int [] array) { printToConsole(PRIMITIVE_PREFIX_FOR_ARRAY + decorateArray(array)); }

    public static void log(int [][] array) { printToConsole(PRIMITIVE_PREFIX_FOR_MATRIX + decorateArray(array)); }

    public static void log(int[][][][] array) { printToConsole(PRIMITIVE_PREFIX_FOR_MULTI_MATRIX + decorateArray(array)); }

    public static void closeLogger() { changeState(BufferState.NONE); }


}


