package com.acme.edu;

import com.acme.edu.command.LoggerMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LoggerController {
    private ConsoleLoggerSaver saver;
    private LoggerMessage currentMessage = new LoggerMessage();

    public LoggerController(ConsoleLoggerSaver saver) {
        this.saver = saver;
    }

    public void log(LoggerMessage newMessage) {
        if (currentMessage.isSameType(newMessage)) {
            currentMessage = currentMessage.accumulate(newMessage);
        } else {
            saver.save(currentMessage.getMessage());
            currentMessage = newMessage;
        }
    }

    public void flush() {
        saver.save(currentMessage.getMessage());
        currentMessage = new LoggerMessage();
    }
}
