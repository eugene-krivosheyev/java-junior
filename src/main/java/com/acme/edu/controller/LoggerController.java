package com.acme.edu.controller;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    private LoggerSaver loggerSaver;
    private LoggerCommand currentLoggerCommand;

    public LoggerController(LoggerSaver loggerSaver) {
        this.loggerSaver = loggerSaver;
    }

    public void log(LoggerCommand newLoggerCommand) {
        if (currentLoggerCommand == null) {
            this.currentLoggerCommand = newLoggerCommand;
        } else if (newLoggerCommand != null && newLoggerCommand.isSameType(this.currentLoggerCommand)) {
            currentLoggerCommand = currentLoggerCommand.accumulate(newLoggerCommand);
        } else {
            loggerSaver.saveMessage(currentLoggerCommand);
            this.currentLoggerCommand = newLoggerCommand;
        }
    }

    public void flush() {
        loggerSaver.saveMessage(currentLoggerCommand);
        currentLoggerCommand = null;
    }
}
