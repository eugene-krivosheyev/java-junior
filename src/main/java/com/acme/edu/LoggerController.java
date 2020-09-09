package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.save.Saver;

public class LoggerController {

    private final Saver saver;
    private Command currentCommand;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void flushBuffers() {
        saver.save(currentCommand);
        currentCommand = null;
    }

    public void log(Command cmd) {
        if (currentCommand != null && currentCommand.isSameType(cmd)) {
            currentCommand = currentCommand.reduce(cmd);
        }
        else {
            if (currentCommand != null)
                saver.save(currentCommand);
            currentCommand = cmd;
        }
    }

}
