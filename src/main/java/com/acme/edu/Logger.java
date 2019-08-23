package com.acme.edu;

import com.acme.edu.command.*;

public class Logger {
    private static byte byteBuffer = 0;
    private static int intBuffer = 0;

    private static BufferState bufferState = BufferState.FLUSHED;

    private static SuperSaver saver = new ConsoleSaver();

    public static void log(boolean message) {
//        flush();
        Command command = new BooleanCommand(message);
        saver.save(command.getDecorated());
    }

    public static void log(byte message) {
//        flushIfOtherState(BufferState.BYTE);
//        byteBuffer += message;
        Command command = new ByteCommand(message);
        saver.save(command.getDecorated());
    }

    public static void log(char message) {
//        flush();
        Command command = new CharCommand(message);
        saver.save(command.getDecorated());
    }

    public static void log(int message) {
//        flushIfOtherState(BufferState.INT);
//        intBuffer += message;
        Command command = new IntCommand(message);
        saver.save(command.getDecorated());
    }

    public static void log(String message) {
//        flush();
        Command command = new StringCommand(message);
        saver.save(command.getDecorated());
    }

    public static void log(int[] array) {
//        flush();
        saver.save(Decorator.PR_ARRAY_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void log(int[][] array) {
//        flush();
        saver.save(Decorator.PR_MATRIX_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void log(Object message) {
//        flush();
        saver.save(Decorator.decorate(message));
    }

    public static void flush() {
        switch (bufferState) {
            case BYTE:
                saver.save(Decorator.decorate(byteBuffer));
                byteBuffer = 0;
                break;
            case INT:
                saver.save(Decorator.decorate(intBuffer));
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
