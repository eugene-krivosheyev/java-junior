package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.arrays.ArrayIntCommand;
import com.acme.edu.commands.arrays.MatrixIntArrayCommand;
import com.acme.edu.commands.arrays.MultimatrixIntCommand;
import com.acme.edu.commands.types.*;
import com.acme.edu.commands.types.primitive.BooleanCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.SaverException;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleSaver());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Logger.class);
    private static final List<Command> buffer = new LinkedList<>();

    public static void log(Object message) throws LogOperationException {
        try {
            loggerController.handleCommand(new ReferenceCommand(message), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(char message) throws LogOperationException {
        try {
            loggerController.handleCommand(new CharCommand(message), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(boolean message) throws LogOperationException {
        try {
            loggerController.handleCommand(new BooleanCommand(message), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(byte message) throws LogOperationException {
        try {
            loggerController.handleCommand(new ByteCommand(message), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(int message) throws LogOperationException {
        try {
            loggerController.handleCommand(new IntCommand(message), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(String message) throws LogOperationException {
        try {
            loggerController.handleCommand(new StringCommand(message), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(int [] array) throws LogOperationException {
        try {
            loggerController.handleCommand(new ArrayIntCommand(array), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(int [][] array) throws LogOperationException {
        try {
            loggerController.handleCommand(new MatrixIntArrayCommand(array), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(int[][][][] array) throws LogOperationException {
        try {
            loggerController.handleCommand(new MultimatrixIntCommand(array), buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }

    public static void log(String... messages) throws LogOperationException {
        for (String message: messages) {
            try {
                loggerController.handleCommand(new StringCommand(message), buffer);
            } catch (SaverException e) {
                log.error("Error in saver");
                throw new LogOperationException("Log operation exception",e);
            }
        }
    }

    public static void log(Integer... messages) throws LogOperationException {
       for (Integer message: messages) {
            try {
                loggerController.handleCommand(new IntCommand(message), buffer);
            } catch (SaverException e) {
                log.error("Error in saver");
                throw new LogOperationException("Log operation exception",e);
            }
        }
    }

    public static void close() throws LogOperationException {
        try {
            loggerController.close(buffer);
        } catch (SaverException e) {
            log.error("Error in saver");
            throw new LogOperationException("Log operation exception",e);
        }
    }
}


