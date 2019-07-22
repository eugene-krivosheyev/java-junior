package com.acme.edu;

import com.acme.edu.command.CommandMessage;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private CommandMessage previousCommand;
    private Saver saver;
    private int logCounter = 1;

    LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(CommandMessage command) {
        logCounter++;
        if (previousCommand != null) {
            previousCommand.update(command, saver);
        }

        previousCommand = command;
    }

    public void flush() {
        boolean isPrimitive = false;
        if (logCounter == 1) {
            isPrimitive = true;
        }
        previousCommand.flush(isPrimitive, saver);
    }

}
