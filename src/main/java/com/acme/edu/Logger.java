package com.acme.edu;


import com.acme.edu.commands.*;
import com.acme.edu.exceptions.LogOperationException;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.ConsoleSaver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Stream;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleSaver()); //Stateless
    private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName());
    private static List<DecorateCommand> commandsBuffer = new ArrayList<>();

    static {
        System.setProperty("java.util.logging.config.file", "logging.properties");
    }

    private static void saveToLog(Throwable e) {
        LOGGER.log(Level.SEVERE, Arrays.toString(e.getStackTrace()));
    }

    private static void processCommand(DecorateCommand newCommand) throws LogOperationException {
        try {
            if (isFlushNeeded(newCommand)) {
                flushBuffer();
            }
            commandsBuffer.add(newCommand);
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(int message) throws LogOperationException {
        processCommand(new PrimitiveCommand(String.valueOf(message)));
    }

    public static void log(byte message) throws LogOperationException {
        processCommand((DecorateCommand) new PrimitiveCommand(String.valueOf(message)));
    }

    public static void log(String message) throws LogOperationException {
        processCommand(new StringCommand(message));
    }

    public static void log(String... messages) throws LogOperationException {
        processCommand((DecorateCommand) new StringCommand(String.join("\n", messages)));
    }

    public static void log(Integer... messages) throws LogOperationException {
        processCommand((DecorateCommand) new PrimitiveCommand(
                Stream.of(messages)
                        .reduce(0, Integer::sum)
                        .toString())
        );
    }

    public static void log(int[][][][] messages) throws LogOperationException {
        processCommand(new MultiMatrixCommand(messages));
    }

    public static void log(int[][] messages) throws LogOperationException {
        processCommand(new MatrixCommand(messages));
    }

    public static void log(int[] messages) throws LogOperationException {
        processCommand(new ArrayCommand(messages));
    }

    public static void log(boolean message) throws LogOperationException {
        processCommand((DecorateCommand) new PrimitiveCommand(String.valueOf(message)));
    }

    public static void log(Object message) throws LogOperationException {
        processCommand(new ReferenceCommand(String.valueOf(message)));
    }

    public static void log(char message) throws LogOperationException {
        processCommand(new CharCommand(String.valueOf(message)));
    }

    private static boolean isFlushNeeded(DecorateCommand newCommand) {
        if (commandsBuffer.size() == 0) {
            return false;
        }
        return !commandsBuffer.get(0).getClass().equals(newCommand.getClass());
    }

    private static void flushBuffer() {
        commandsBuffer.forEach(loggerController::run);
        commandsBuffer.clear();
    }

    public static void close() throws LogOperationException {
        try {
            flushBuffer();
            loggerController.close();
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }
}
