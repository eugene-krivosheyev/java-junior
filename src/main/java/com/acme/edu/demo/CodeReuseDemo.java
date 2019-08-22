package com.acme.edu.demo;

public class CodeReuseDemo {
    private static int[] intBuffer;
    private static byte[] byteBuffer;

    public static void main(String[] args) {

    }

    static void addInBuffer(int message) {
        handleOverflow(
                message,
                Integer.MAX_VALUE, Integer.MIN_VALUE,
                CodeReuseDemo::clearBufferInt
        );
    }

    static void addInBuffer(byte message) {
        handleOverflow(
                message,
                Byte.MAX_VALUE, Byte.MIN_VALUE,
                CodeReuseDemo::clearBufferByte);
    }

    private static void handleOverflow(int message, int maxValue, int minValue, Todo todo) {
        int result = maxOrMinIfOverflow(message);
        if (result == maxValue || result == minValue) {
            todo.execute();
            intBuffer[0] = result;
        }
        else {
            intBuffer[0] += result;
        }
    }

    //region impl
    private static void clearBufferByte() {

    }

    private static byte maxOrMinIfOverflow(int message) {
        return 0;
    }

    private static void clearBufferInt() {

    }
    //endregion
}

@FunctionalInterface
interface Todo {
    void execute();
}