package com.acme.edu;

import com.acme.edu.message.Message;
import com.acme.edu.saver.LoggerSaver;
import com.acme.edu.decorator.LoggerDecorator;

public class LoggerController {
    private Message currentMessage;
    private LoggerSaver saver;
    private LoggerDecorator decorator;

    public LoggerController(LoggerSaver saver, LoggerDecorator decorator) {
        this.saver = saver;
        this.decorator = decorator;
    }

    public void log(Message message) {
        if (currentMessage == null) {
            currentMessage = message;
            return;
        }

        if (currentMessage.isSameTypeOf(message)) {
            currentMessage.accumulate(message);
        } else {
            flush();
            currentMessage = message;
        }
    }

    public void flush() {
        String decoratedMessage = decorator.decorate(currentMessage);
        saver.save(decoratedMessage);
        currentMessage = null;
    }


}
