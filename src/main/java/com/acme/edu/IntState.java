package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class IntState extends Printer implements LoggerState{
    Printer printer;
    private int buffer = 0;

    public IntState(Printer mock) {
        this.printer = mock;
    }

    @Override
    public void log(String message) {
        checkMaxAndOverFlow(Integer.parseInt(message));
        buffer += Integer.parseInt(message);
    }

    @Override
    public void flush() {
            printer.print(PRIMITIVE + String.valueOf(buffer));
            buffer = 0;
    }

    private void checkMaxAndOverFlow(int message) {
        if (message == Integer.MAX_VALUE || message == Byte.MAX_VALUE || message == Integer.MIN_VALUE || message == Byte.MIN_VALUE) {
            flush();
        }

        if ((long)message + buffer  > Integer.MAX_VALUE ){
            flush();
        }
        if ((long)message + buffer  < Integer.MIN_VALUE ){
            flush();
        }
    }

    @Override
    public void log(int[] array) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void log(int[][] matrix) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void log(int[][][][] multiMatrix) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void log(String... elements) {
        throw new UnsupportedOperationException();
    }
}
