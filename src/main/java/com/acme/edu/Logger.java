package com.acme.edu;


import com.acme.edu.commands.*;

import java.util.stream.Stream;

public class Logger {
    private static LoggerController loggerController = new LoggerController(); //Stateless

    public static void log(int message) {
        loggerController.run(new PrimitiveCommand(message));
    }

    public static void log(byte message) {
        loggerController.run((DecorateCommand) new PrimitiveCommand(String.valueOf(message)));
    }

    public static void log(String message) {
        loggerController.run(new StringCommand(message));
    }

    public static void log(String... messages) {
        loggerController.run((DecorateCommand) new StringCommand(String.join("\n", messages)));
    }

    public static void log(Integer... messages) {
        loggerController.run(
                (DecorateCommand) new PrimitiveCommand(Stream.of(messages).reduce(0, Integer::sum).toString())
        );
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
        loggerController.run((DecorateCommand) new PrimitiveCommand(String.valueOf(message)));
    }

    public static void log(Object message) {
        loggerController.run(new ReferenceCommand(String.valueOf(message)));
    }

    public static void log(char message) {
        loggerController.run(new CharCommand(String.valueOf(message)));
    }

    public static void close() {
        loggerController.close();
    }
}
