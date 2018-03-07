package com.acme.edu;

public class Flusher {
    private static Object buffer;
    private static boolean usage;
    private static int counter;

    public static Object getBuffer() {
        return buffer;
    }

    public static boolean isUsage() {
        return usage;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setBuffer(Object buffer) {
        Flusher.buffer = buffer;
    }

    public static void setUsage(boolean usage) {
        Flusher.usage = usage;
    }

    public static void setCounter(int counter) {
        Flusher.counter = counter;
    }
}
