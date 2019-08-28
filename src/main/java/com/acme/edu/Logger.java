package com.acme.edu;


import com.acme.edu.commands.*;
import com.acme.edu.exceptions.LogOperationException;
import com.acme.edu.exceptions.SaverException;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.stream.Stream;

public class Logger {
    private static LoggerController loggerController = new LoggerController(); //Stateless
    private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName());

    private static void saveToLog(Throwable e){
        LOGGER.log(Level.SEVERE, Arrays.toString(e.getStackTrace()));
    }

    public static void log(int message) throws LogOperationException {
        try {
            loggerController.run(new PrimitiveCommand(message));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(byte message) throws LogOperationException {
        try {
            loggerController.run((DecorateCommand) new PrimitiveCommand(String.valueOf(message)));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(String message) throws LogOperationException {
        try {
            loggerController.run(new StringCommand(message));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(String... messages) throws LogOperationException {
        try {
            loggerController.run((DecorateCommand) new StringCommand(String.join("\n", messages)));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(Integer... messages) throws LogOperationException {
        try {
            loggerController.run(
                    (DecorateCommand) new PrimitiveCommand(Stream.of(messages).reduce(0, Integer::sum).toString())
            );
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(int[][][][] messages) throws LogOperationException {
        try {
            loggerController.run(new MultiMatrixCommand(messages));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(int[][] messages) throws LogOperationException {
        try {
            loggerController.run(new MatrixCommand(messages));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(int[] messages) throws LogOperationException {
        try {
            loggerController.run(new ArrayCommand(messages));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(boolean message) throws LogOperationException {
        try {
            loggerController.run((DecorateCommand) new PrimitiveCommand(String.valueOf(message)));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(Object message) throws LogOperationException {
        try {
            loggerController.run(new ReferenceCommand(String.valueOf(message)));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void log(char message) throws LogOperationException {
        try {
            loggerController.run(new CharCommand(String.valueOf(message)));
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }

    public static void close() throws LogOperationException {
        try {
            loggerController.close();
        } catch (SaverException e) {
            saveToLog(e);
            throw new LogOperationException(e);
        }
    }
}
