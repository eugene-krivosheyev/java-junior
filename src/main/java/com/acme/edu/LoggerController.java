package com.acme.edu;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    LoggerSaver saver;
    LoggerCommand currentState;

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
        currentState = null;
    }

    public void log(LoggerCommand message) {
        if (currentState == null) {
            currentState = message;
        }
        else if (currentState.checkFlush(message)) {
            saver.save(currentState.getDecoratedSelf());
            currentState = message;
        }
        else
            currentState.accumulate(message);
    }

    public void flush() {
        saver.save(currentState.getDecoratedSelf());
        currentState = null;
    }
}
