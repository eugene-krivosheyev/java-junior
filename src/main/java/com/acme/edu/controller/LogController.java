package com.acme.edu.controller;

import com.acme.edu.message.BlankMessage;
import com.acme.edu.decorator.LoggerDecorator;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LogController {
    private transient Message previousMessage = new BlankMessage();
    private final transient ConsoleLoggerSaver saver;
    private final transient LoggerDecorator decorator;

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
