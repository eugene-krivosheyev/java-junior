package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class ByteAccumulator implements Accumulator {

    @Override
    public void add(Command command) {
        accumulateNumberConcerningMaxValue(((ByteCommand)command).getMessage(), Byte.MAX_VALUE);
    }

    private static long numberBuffer = 0;
    private static boolean isNumberBufferNotEmpty = false;

    private static void flushByteState() {
        if (isNumberBufferNotEmpty) {
            decorateAndPrintPrimitive(String.valueOf(numberBuffer));
        }
        cleanNumberBuffer();
    }

    private static void cleanNumberBuffer() {
        numberBuffer = 0;
        isNumberBufferNotEmpty = false;
    }

    private static void accumulateNumberConcerningMaxValue(int number, int maxValue) {
        if (numberBuffer + number >= maxValue) {
            flushByteState();
        }
        isNumberBufferNotEmpty = true;
        numberBuffer += number;
    }
}

