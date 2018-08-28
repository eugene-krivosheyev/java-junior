package com.acme.edu.controller;

import com.acme.edu.messagelog.BlankMessage;
import com.acme.edu.messagelog.LoggerDecorator;
import com.acme.edu.messagelog.Message;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LogController {
    private Message previousMessage = new BlankMessage();
    private final ConsoleLoggerSaver saver;
    private final LoggerDecorator decorator;

    public LogController(ConsoleLoggerSaver saver, LoggerDecorator decorator) {
        this.saver = saver;
        this.decorator = decorator;
    }

    public void log(Message message) {
        if (previousMessage.canBeAccumulated(message)) {
            previousMessage = previousMessage.accumulate(message);
        } else {
            flush();
            previousMessage = message;
        }
    }

    public void flush() {
        if (previousMessage instanceof BlankMessage) return;
        saver.save(previousMessage.getFormattedMessage(decorator));
        previousMessage = new BlankMessage();
    }
}
