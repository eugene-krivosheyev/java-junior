package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class IntAccumulator implements Accumulator {

    @Override
    public void add(Command command) {
        accumulateNumberConcerningMaxValue(((IntCommand)command).getMessage(), Integer.MAX_VALUE);
    }

    private static long numberBuffer = 0;
    private static boolean isNumberBufferNotEmpty = false;

    private static void flushIntState() {
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
            flushIntState();
        }
        isNumberBufferNotEmpty = true;
        numberBuffer += number;
    }
}
