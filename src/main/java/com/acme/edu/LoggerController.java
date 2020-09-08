package com.acme.edu;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    LoggerSaver saver;
    LoggerCommand currentState;

    /**
     * Constructor with dependency injection
     * @see LoggerSaver
     * @param saver - responsible for saving message
     */
    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
        currentState = null;
    }

    /**
     * Main logger workflow: check flush, save message, accumulate state
     * @see LoggerCommand
     * @param command - new incoming message
     */
    public void log(LoggerCommand command) {
        if (currentState == null) {
            currentState = command;
        } else if (currentState.checkFlush(command)) {
            saver.save(currentState.getDecoratedSelf());
            currentState = command;
        } else {
            currentState.accumulate(command);
        }
    }

    /**
     * Flush logger buffer and revert to default state
     */
    public void flush() {
        saver.save(currentState.getDecoratedSelf());
        currentState = null;
    }
}
