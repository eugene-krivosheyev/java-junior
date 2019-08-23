package com.acme.edu;


import com.acme.edu.accumulateCommands.PrimitiveAccumulateCommand;
import com.acme.edu.accumulateCommands.StringAccumulateCommand;
import com.acme.edu.decorateComands.*;

import java.util.stream.Stream;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void log(int message) {
        loggerController.run(new PrimitiveAccumulateCommand(message));
    }

    public static void log(byte message) {
        loggerController.run(new PrimitiveDecorateCommand(String.valueOf(message)));
    }

    public static void log(String message) {
        loggerController.run(new StringAccumulateCommand(message));
    }

    public static void log(String... messages) {
        loggerController.run(new StringDecorateCommand(String.join("\n", messages)));
    }

    public static void log(Integer... messages) {
        loggerController.run(new PrimitiveDecorateCommand(Stream.of(messages).reduce(0, Integer::sum).toString()));
    }

    public static void log(int[][][][] messages) {
        loggerController.run(new MultiMatrixDecorateCommand(messages));
    }

    public static void log(int[][] messages) {
        loggerController.run(new MatrixDecorateCommand(messages));
    }

    public static void log(int[] messages) {
        loggerController.run(new ArrayDecorateCommand(messages));
    }

    public static void log(boolean message) {
        loggerController.run(new PrimitiveDecorateCommand(String.valueOf(message)));
    }

    public static void log(Object message) {
        loggerController.run(new ReferenceDecorateCommand(String.valueOf(message)));
    }

    public static void log(char message) {
        loggerController.run(new CharDecorateCommand(String.valueOf(message)));
    }

    public static void close() {
       loggerController.close();
    }
}