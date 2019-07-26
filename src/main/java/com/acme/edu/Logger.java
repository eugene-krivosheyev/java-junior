package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.Saver;

import java.io.IOException;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleLoggerSaver());

    public static void setSaver(Saver saver){
        loggerController.setLoggerSaver(saver);
    }

    public static void flush() throws IOException {
        loggerController.flush();
    }

    public static void close() throws IOException {
        flush();
        loggerController.close();
    }

    public static void log(int message) throws Exception {
        loggerController.log(new IntCommand(message));
    }

    public static void log(int... message) throws Exception {
        loggerController.log(new IntMasCommand(message));
    }

    public static void log(int[][] message) throws Exception {
        loggerController.log(new IntMas2Command(message));
    }

    public static void log(int[][][][] message)  throws Exception {
        loggerController.log(new IntMas4Command(message));
    }

    public static void log(byte message)  throws Exception {
        loggerController.log(new ByteCommand(message));
    }

    public static void log(char message)  throws Exception {
        loggerController.log(new CharCommand(message));
    }

    public static void log(String message )  throws Exception {
        loggerController.log(new StringCommand(message));
    }

    public static void log(String... message)  throws Exception {
        for(String s:message)
            loggerController.log(new StringCommand(s));
    }

    public static void log(Boolean message)  throws Exception {
        loggerController.log(new BooleanCommand(message));
    }

    public static void log(Object message)  throws Exception {
        loggerController.log(new ObjectCommand(message));
    }
}
