package com.acme.edu;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exception.BufferOverflowException;
import com.acme.edu.exception.FlushException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    private LoggerSaver saver;
    LoggerCommand currentState;

    /**
     * Constructor with dependency injection
     * @see LoggerSaver
     * @param saver - responsible for saving message
     */
    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
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
                flush(command);
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
    public void flush(LoggerCommand state) throws FlushException {
        try {
            saver.save(currentState.getDecoratedSelf());
            currentState = state;
        } catch(SaveException e){
            e.printStackTrace();
            throw  new FlushException("flush error: unable to save", e);
        }
    }
}
