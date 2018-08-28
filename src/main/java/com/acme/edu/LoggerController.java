package com.acme.edu;

import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.Message;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    private Message currentMessage;
    private LoggerSaver saver;

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
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
        saver.save(currentMessage);
        currentMessage = null;
    }
}
