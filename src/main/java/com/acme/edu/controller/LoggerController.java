package com.acme.edu.controller;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exception.IntLogException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.StringLogException;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    private LoggerSaver loggerSaver;
    private LoggerCommand currentLoggerCommand;

    public LoggerController(LoggerSaver loggerSaver) {
        this.loggerSaver = loggerSaver;
    }

    public void log(LoggerCommand newLoggerCommand) throws LogException{
        try {
            if (currentLoggerCommand == null) {
                this.currentLoggerCommand = newLoggerCommand;
            } else if (newLoggerCommand.isSameType(this.currentLoggerCommand)) {
                currentLoggerCommand = currentLoggerCommand.accumulate(newLoggerCommand);
            } else {
                loggerSaver.saveMessage(currentLoggerCommand);
                this.currentLoggerCommand = newLoggerCommand;
            }
        }
        catch(StringLogException | NullPointerException | IntLogException e) {
            throw new LogException("Invalid parameter exception: " + e.getMessage(), e);
        }
    }

    public void flush() {
        loggerSaver.saveMessage(currentLoggerCommand);
        currentLoggerCommand = null;
    }
}
