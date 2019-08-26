package com.acme.edu;


import com.acme.edu.commands.*;

public class Logger {

    private static LoggerController loggerController = new LoggerController();

    public static void log(int message) {
        Command command = new IntCommand(message);
        loggerController.log(command);
    }

    public static void log(byte message) {
        Command command = new ByteCommand(message);
        loggerController.log(command);
    }

    public static void log(String message) {
        Command command = new StringCommand(message);
        loggerController.log(command);
    }

    public static void log(boolean message) {
        Command command = new BoolCommand(message);
        loggerController.log(command);
    }

    public static void log(Object message) {
        Command command = new ObjectCommand(message);
        loggerController.log(command);
    }

    public static void log(char message) {
        Command command = new CharCommand(message);
        loggerController.log(command);
    }

    public static void log(int[] message) {
        Command command = new ArrayCommand(message);
        loggerController.log(command);
    }

    public static void log(int[][] message) {
        Command command = new MatrixCommand(message);
        loggerController.log(command);
    }

    public static void log(String... messages) {
        for (String message : messages) {
            log(message);
        }
    }
    
    public static void flush() {
        loggerController.flush();
    }

}
