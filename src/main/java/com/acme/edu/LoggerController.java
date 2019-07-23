package com.acme.edu;

import com.acme.edu.command.CommandMessage;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Saver saver;
    private CommandMessage previousCommand;
    private int logCounter = 0;

    public LoggerController(Saver saver) {
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
        String primitiveDecoration = logCounter == 1 ? previousCommand.primitiveDecorator() : "";
        saver.save(primitiveDecoration);
        previousCommand.flush(saver);
        logCounter = 0;
        previousCommand = null;
    }

}
