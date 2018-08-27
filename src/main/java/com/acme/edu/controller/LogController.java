package com.acme.edu.controller;

import com.acme.edu.decorator.LoggerDecorator;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LogController {
    private Message previousMessage;
    private ConsoleLoggerSaver saver;
    private LoggerDecorator decorator;

    public LogController(ConsoleLoggerSaver saver, LoggerDecorator decorator) {
        this.saver = saver;
        this.decorator = decorator;
    }

    public void log(Message message) {
        if (previousMessage == null){
            previousMessage = message;
            return;
        }

        if (message.canBeAccumulated(previousMessage)) {
            previousMessage = previousMessage.accumulate(message);
        } else {
            flush();
            previousMessage = message;
        }
    }

    public void flush(){
        saver.save(previousMessage.getFormattedMessage(decorator));
        previousMessage = null;
    }
}
