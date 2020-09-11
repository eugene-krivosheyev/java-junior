package com.acme.edu.controller;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exceptions.ControllerException;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    private LoggerSaver loggerSaver;
    private LoggerCommand currentLoggerCommand;

    public LoggerController(LoggerSaver loggerSaver) {
        this.loggerSaver = loggerSaver;
    }

    public void log(LoggerCommand newLoggerCommand) throws ControllerException {
        try {
            if (currentLoggerCommand == null) {
                this.currentLoggerCommand = newLoggerCommand;
            } else if (newLoggerCommand != null) {
                if (newLoggerCommand.isSameType(this.currentLoggerCommand)) {
                    currentLoggerCommand = currentLoggerCommand.accumulate(newLoggerCommand);
                } else {
                    loggerSaver.saveMessage(currentLoggerCommand);
                    this.currentLoggerCommand = newLoggerCommand;
                }
            } else {
                throw new NullPointerException("new command is null");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new ControllerException("cannot log new command");
        }
    }

    public void flush() {
        loggerSaver.saveMessage(currentLoggerCommand);
        currentLoggerCommand = null;
    }
}
