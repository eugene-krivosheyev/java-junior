package com.acme.edu.controller;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exception.IntLogException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.exception.StringLogException;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    private LoggerSaver loggerSaver;
    private LoggerCommand currentLoggerCommand;

    public LoggerController(LoggerSaver loggerSaver) {
        this.loggerSaver = loggerSaver;
    }

    public void log(LoggerCommand newLoggerCommand) throws LogException {
        try {
            if (currentLoggerCommand == null) {
                this.currentLoggerCommand = newLoggerCommand;
            } else if (newLoggerCommand.isSameType(this.currentLoggerCommand)) {
                currentLoggerCommand = currentLoggerCommand.accumulate(newLoggerCommand);
            } else {
                flush(newLoggerCommand);
            }
        } catch (NullPointerException e) {
            throw new LogException("Invalid parameter exception: new command is null", e);
        } catch (IntLogException e) {
            throw new LogException("Invalid integer parameter exception: " + e.getMessage(), e);
        } catch (StringLogException e) {
            throw new LogException("Invalid string parameter exception: " + e.getMessage(), e);
        }
    }

    public void flush(LoggerCommand currentLoggerCommand) throws LogException {
        try {
            loggerSaver.saveMessage(this.currentLoggerCommand);
            this.currentLoggerCommand = currentLoggerCommand;
        } catch (SaveException e) {
            throw new LogException("Can't save message: " + e.getMessage(), e);
        }
    }
}
