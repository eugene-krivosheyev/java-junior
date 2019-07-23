package com.acme.edu;

import com.acme.edu.command.CommandMessage;
import com.acme.edu.exceptions.NullCommandFlushException;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Saver saver;
    private CommandMessage previousCommand;
    private int logCounter = 0;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void setPreviousCommand(CommandMessage previousCommand) {
        this.previousCommand = previousCommand;
    }

    public void setLogCounter(int logCounter) {
        this.logCounter = logCounter;
    }

    public void log(CommandMessage command) {
        logCounter++;
        if (previousCommand != null) {
            previousCommand.update(command, saver);
        }
        setPreviousCommand(command);
    }

    public void flush() throws NullCommandFlushException{
        String primitiveDecoration = logCounter == 1 ? previousCommand.primitiveDecorator() : "";
        saver.save(primitiveDecoration);
        try {
            previousCommand.flush(saver);
        } catch (NullPointerException e){
            throw new NullCommandFlushException("Failed to flush!", e);
        }
        setLogCounter(0);
        setPreviousCommand(null);
    }

}
