package com.acme.edu.controller;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exception.IntLogException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.exception.StringLogException;
import com.acme.edu.saver.LoggerSaver;

import java.util.Arrays;

public class LoggerController {
    private Iterable<LoggerSaver> loggerSaver;
    private LoggerCommand currentLoggerCommand;

    public LoggerController(LoggerSaver... loggerSaver) {
        this.loggerSaver = Arrays.asList(loggerSaver);
    }

    /**
     * Accumulating messages with same types in currentLoggerCommand
     * Flushes currentLoggerCommand if new command has different type
     *
     * @param newLoggerCommand
     * @throws LogException
     */
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

    /**
     * Save currentLoggerCommand for each saver
     *
     * @param currentLoggerCommand
     */
    public void flush(LoggerCommand currentLoggerCommand) {
        loggerSaver.forEach(s -> {
            try {
                s.saveMessage(this.currentLoggerCommand);
            } catch (SaveException e) {
                try {
                    throw new LogException("Cannot save message cased by " + e.getMessage(), e);
                } catch (LogException logException) {
                    System.out.println("Can't save message. Exception was thrown caused by" + e.getCause() +
                            " with message " + e.getMessage());
                    logException.printStackTrace();
                }
            }
        });
        this.currentLoggerCommand = currentLoggerCommand;
    }
}
