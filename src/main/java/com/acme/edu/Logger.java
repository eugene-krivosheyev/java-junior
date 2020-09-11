package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.exceptions.ControllerException;

public class Logger {

    private static final LoggerController loggerController = new LoggerController(System.out::println);

    public static void flush() {
        loggerController.flush();
    }

    public static void log(int message) throws ControllerException {
        loggerController.log(new IntCommand(message));
    }

    public static void log(String message) throws ControllerException {
        loggerController.log(new StringCommand(message));
    }

}
