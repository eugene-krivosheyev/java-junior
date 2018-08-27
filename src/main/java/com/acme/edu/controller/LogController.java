package com.acme.edu.controller;

import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LogController {
    private Message previousMessage;
    private ConsoleLoggerSaver saver;

    public LogController(ConsoleLoggerSaver saver) {
        this.saver = saver;
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
        saver.save(previousMessage.getFormattedMessage());
        previousMessage = null;
    }
}
