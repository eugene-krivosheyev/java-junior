package com.acme.edu;

import com.acme.edu.message.DefaultMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LoggerController {
    private ConsoleLoggerSaver saver;
    private LoggerMessage currentMessage = new DefaultMessage();

    public LoggerController(ConsoleLoggerSaver saver) {
        this.saver = saver;
    }

    public void setCurrentMessage(LoggerMessage currentMessage) {
        this.currentMessage = currentMessage;
    }

    public void log(LoggerMessage newMessage) {
        if (currentMessage.isSameType(newMessage) && currentMessage.isNotOverflowed(newMessage)) {
            currentMessage = currentMessage.accumulate(newMessage);
        } else {
            saver.save(currentMessage.getMessage());
            currentMessage = newMessage;
        }
    }

    public void flush() {
        saver.save(currentMessage.getMessage());
        currentMessage = new DefaultMessage();
    }
}
