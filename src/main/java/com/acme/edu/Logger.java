package com.acme.edu;

import com.acme.edu.MessageDecorator.DefaultDecorator;
import com.acme.edu.Saver.ConsoleSaver;


public class Logger {
    private static LogWorker logWorker = new LogWorker(new ConsoleSaver(), new DefaultDecorator());

    public static void flushIntegerBuffer() {
        logWorker.flushIntegerBuffer();
    }

    public static void flushStringBuffer() {
        logWorker.flushStringBuffer();
    }

    public static void log(int message) {
        logWorker.log(message);
    }

    public static void log(byte message) {
        logWorker.log(message);
    }

    public static void log(char message) {
        logWorker.log(message);
    }

    public static void log(String message) {
        logWorker.log(message);
    }

    public static void log(boolean message) {
        logWorker.log(message);
    }

    public static void log(int[] message) {
        logWorker.log(message);
    }

    public static void log(int[][] message) {
        logWorker.log(message);
    }

    public static void log(Object message) {
        logWorker.log(message);
    }
}
