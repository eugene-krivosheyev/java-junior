package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.saver.ConsoleSaver;

/**
 * Logger facade
 */
public class Logger {
    LoggerController myLoggerController = new LoggerController(new ConsoleSaver());

    public void log(int message) {
        myLoggerController.log(new IntCommand(message));
    }

    public void log(String message) {
        myLoggerController.log(new StringCommand(message));
    }

    public void flush() {
        myLoggerController.flush();
    }
}
