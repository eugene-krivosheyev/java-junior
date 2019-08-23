package com.acme.edu;


import com.acme.edu.comands.*;

import java.util.stream.Stream;

public class Logger {
    private static Buffer buffer = new Buffer();
    private static LoggerController loggerController = new LoggerController();

    public static void log(int message) {
        buffer.save(message);
    }

    public static void log(byte message) {
        loggerController.run(new PrimitiveCommand(String.valueOf(message)));
    }

    public static void log(String message) {
        buffer.save(message);
    }

    public static void log(String... messages) {
        loggerController.run(new StringCommand(String.join("\n", messages)));
    }

    public static void log(Integer... messages) {
        loggerController.run(new PrimitiveCommand(Stream.of(messages).reduce(0, Integer::sum).toString()));
    }

    public static void log(int[][][][] messages) {
        loggerController.run(new MultiMatrixCommand(messages));
    }

    public static void log(int[][] messages) {
        loggerController.run(new MatrixCommand(messages));
    }

    public static void log(int[] messages) {
        loggerController.run(new ArrayCommand(messages));
    }

    public static void log(boolean message) {
        loggerController.run(new PrimitiveCommand(String.valueOf(message)));
    }

    public static void log(Object message) {
        loggerController.run(new ReferenceCommand(String.valueOf(message)));
    }

    public static void log(char message) {
        loggerController.run(new CharCommand(String.valueOf(message)));
    }

    public static void close() {
        buffer.flushBuffer();
    }
}