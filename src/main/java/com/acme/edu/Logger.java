package com.acme.edu;

import com.acme.edu.command.ByteCommand;
import com.acme.edu.command.IntegerCommand;
import com.acme.edu.command.StringCommand;

import java.util.Arrays;

public class Logger {
    private static LoggerController loggerController = LoggerRegistry.getLoggerController();

    public static void setDecoration(boolean decoration) {
        loggerController.setDecorateCommandParameter(decoration);
    }

    public static void setAccumulation(boolean accumulation) {
        loggerController.setAccumulateCommandParameter(accumulation);
    }

    public static void flush() {
        loggerController.flush();
    }

    public static void reset() {
        loggerController.resetCommandParameters();
    }

    public static void log(byte message) {
        loggerController.send(new ByteCommand(message));
    }

    public static void log(int message) {
        loggerController.send(new IntegerCommand(message));
    }

    public static void log(String message) {
        loggerController.send(new StringCommand(message));
    }

    public static void log(int... messages) {
        Arrays.stream(messages).forEach(m -> loggerController.send(new IntegerCommand(m)));
    }

    public static void log(String... messages) {
        Arrays.stream(messages).forEach(m -> loggerController.send(new StringCommand(m)));
    }
}
