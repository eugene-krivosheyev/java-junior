package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.controller.LoggerController;

public class Logger {

    private static final LoggerController loggerController = new LoggerController(System.out::println);

    public static void flush() {
        loggerController.flush();
    }

    public static void log(int message) {
        loggerController.log(new IntCommand(message));
    }

    public static void log(String message) {
        loggerController.log(new StringCommand(message));
    }

}
