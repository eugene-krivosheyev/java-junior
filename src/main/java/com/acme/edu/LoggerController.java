package com.acme.edu;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.saver.LoggerSaver;
import javafx.fxml.LoadException;

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
    public void log(LoggerCommand command) throws Logger.LogException {
        try {
            if (currentState == null) {
                currentState = command;
            } else if (currentState.checkFlush(command)) {
                saver.save(currentState.getDecoratedSelf());
                currentState = command;
            } else {
                currentState.accumulate(command);
            }
        } catch (LoggerSaver.SaveException | LoggerCommand.BufferOverflowException e) {
            e.printStackTrace();
            throw new Logger.LogException();
        }
    }

    /**
     * Flush logger buffer and revert to default state
     */
    public void flush() throws Logger.FlushException {
        try {
            saver.save(currentState.getDecoratedSelf());
            currentState = null;
        } catch(LoggerSaver.SaveException e){
            e.printStackTrace();
            throw  new Logger.FlushException();
        }
    }
}
