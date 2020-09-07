package com.acme.edu;

public class LoggerController {
    private LoggerSaver saver;
    private LoggerMessage currentState = null;

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(LoggerMessage newMessage) {
        if (currentState == null) {
            currentState = newMessage;
        } else {
            if (newMessage.isSameType(currentState)) {
                currentState.accumulate(newMessage);
            } else {
                saver.save(currentState.getMessage());
                currentState = newMessage;
            }
        }
    }

    public void flush() {
        saver.save(currentState.getMessage());
        currentState = null;
    }
}
