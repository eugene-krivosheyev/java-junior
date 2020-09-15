package com.acme.edu;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exception.BufferOverflowException;
import com.acme.edu.exception.FlushException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.saver.LoggerSaver;

import java.util.Arrays;

public class LoggerController {
    private Iterable<LoggerSaver> savers;
    LoggerCommand currentState;

    /**
     * Constructor with dependency injection
     * @see LoggerSaver
     * @param savers - responsible for saving message
     */
    public LoggerController(LoggerSaver... savers) {
        this.savers = Arrays.asList(savers);
    }

    /**
     * Main logger workflow: check flush, save message, accumulate state
     * @see LoggerCommand
     * @param command - new incoming message
     */
    public void log(LoggerCommand command) throws LogException {
        try {
            if (currentState == null) {
                currentState = command;
            } else if (currentState.checkFlush(command)) {
                flush();
                currentState = command;
            } else {
                currentState.accumulate(command);
            }
        } catch (BufferOverflowException | FlushException e) {
            e.printStackTrace();
            throw new LogException("log error", e);
        }
    }

    /**
     * Flush logger buffer and revert to default state
     */
    public void flush() throws FlushException {
        savers.forEach(s -> {
            try {
                s.save(currentState.getDecoratedSelf());
            } catch (SaveException e) {
                e.printStackTrace();
            }
        });
        currentState = null;
    }
}
