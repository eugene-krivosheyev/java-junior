package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.exception.LogException;
import com.acme.edu.saver.FileSaver;

public class Logger {

    private static LoggerController loggerController = new LoggerController(System.out::println, new FileSaver());

    public static void flush() {
        loggerController.flush(null);
    }

    public static void log(int message) {
        try {
            loggerController.log(new IntCommand(message));
        } catch (LogException e) {
            System.out.println("Can't log message. Exception was thrown caused by" + e.getCause() +
                    " with message " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        try {
            loggerController.log(new StringCommand(message));
        } catch (LogException e) {
            System.out.println("Can't log message. Exception was thrown caused by" + e.getCause() +
                    " with message " + e.getMessage());
            e.printStackTrace();
        }
    }

}
