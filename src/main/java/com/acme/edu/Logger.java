package com.acme.edu;


import static com.acme.edu.Decorator.decorateArray;
import static com.acme.edu.Decorator.decorateString;

public class Logger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    private static final String PRIMITIVE_PREFIX_FOR_ARRAY = "primitives array: ";
    private static final String PRIMITIVE_PREFIX_FOR_MATRIX = "primitives matrix: ";
    private static final String PRIMITIVE_PREFIX_FOR_MULTI_MATRIX = "primitives multimatrix: ";

    private static BufferState state = BufferState.NONE;

    // -------------- METHODS FOR LOG ------------------

    public static void log(Object message) {
        decorateString(REFERENCE_PREFIX, message);
    }

    public static void log(char message) {
       decorateString(CHAR_PREFIX, message);
    }

    public static void log(boolean message) {
        decorateString(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        if(state != BufferState.BYTE) {
            changeState(BufferState.BYTE);
        }
        Buffer.addInBuffer(message);
        decorateString(PRIMITIVE_PREFIX, message);
    }

    public static void log(int message) {
        if(state != BufferState.INT) {
            changeState(BufferState.INT);
        }
        Buffer.addInBuffer(message);
        decorateString(PRIMITIVE_PREFIX, message);
    }

    public static void log(String message) {
        if(state != BufferState.STR) {
            changeState(BufferState.STR);
        }
        Buffer.addInBuffer(message);
        decorateString(STRING_PREFIX, message);
    }

    public static void log(int [] array) {
        System.out.println(PRIMITIVE_PREFIX_FOR_ARRAY + decorateArray(array));
    }

    public static void log(int [][] array) {
        System.out.println(PRIMITIVE_PREFIX_FOR_MATRIX + decorateArray(array));
    }

    public static void log(int[][][][] array) {
        System.out.println(PRIMITIVE_PREFIX_FOR_MULTI_MATRIX + decorateArray(array));
    }

    // -------------- CHANGE STATE------------------

    private static void changeState(BufferState newState) {
        switch (state){
            case BYTE:
                Buffer.clearBufferByte();
                break;
            case INT:
                Buffer.clearBufferInt();
                break;
            case STR:
                Buffer.clearBufferStr();
                break;
            default:
                break;
        }
        state = newState;
    }

    // -------------- CLOSE------------------

    public static void closeBuffer() { changeState(BufferState.NONE); }
}


