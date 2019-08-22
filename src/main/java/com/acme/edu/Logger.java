package com.acme.edu;

public class Logger {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static final String PRIMITIVES_PREFIX = "primitives ";
    public static final String PR_ARRAY_PREFIX = PRIMITIVES_PREFIX + "array: ";
    public static final String PR_MATRIX_PREFIX = PRIMITIVES_PREFIX + "matrix: ";
    public static final String PR_MULTIMATRIX_PREFIX = PRIMITIVES_PREFIX + "multimatrix: ";

    private static byte byteBuffer = 0;
    private static int intBuffer = 0;

    private static BufferState bufferState = BufferState.FLUSHED;


    public static void log(boolean message) {
        flush();
        PrintUtils.printToStdout(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        flushIfOtherState(BufferState.BYTE);
        byteBuffer += message;
    }

    public static void log(char message) {
        flush();
        PrintUtils.printToStdout(CHAR_PREFIX + message);
    }

    public static void log(int message) {
        flushIfOtherState(BufferState.INT);
        intBuffer += message;
    }

    public static void log(String message) {
        flush();
        PrintUtils.printToStdout(STRING_PREFIX + message);
    }

    public static void log(int[] array) {
        flush();
        PrintUtils.printToStdout(PR_ARRAY_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void log(int[][] array) {
        flush();
        PrintUtils.printToStdout(PR_MATRIX_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void log(Object message) {
        flush();
        PrintUtils.printToStdout(REFERENCE_PREFIX + message);
    }

    public static void flush() {
        switch (bufferState) {
            case BYTE:
                PrintUtils.printToStdout(PRIMITIVE_PREFIX + byteBuffer);
                byteBuffer = 0;
                break;
            case INT:
                PrintUtils.printToStdout(PRIMITIVE_PREFIX + intBuffer);
                intBuffer = 0;
                break;
            case FLUSHED:
                break;
        }
        bufferState = BufferState.FLUSHED;
    }

    private static void setBufferState(BufferState bufferState) {
        Logger.bufferState = bufferState;
    }

    private static void flushIfOtherState(BufferState state) {
        if (bufferState != state) {
            flush();
            setBufferState(state);
        }
    }

    private enum BufferState {
        BYTE,
        INT,
        FLUSHED
    }
}
