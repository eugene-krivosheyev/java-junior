package com.acme.edu;

import com.acme.edu.message.Message;

public class LoggerController {

    private Message currentMessage;
    private LoggerSaver saver;

    public LoggerController(LoggerSaver loggerSaver) {
        this.saver = loggerSaver;
    }

    public void log(Message message) {
        if (currentMessage == null) {
            currentMessage = message;
            return;
        }
        if (currentMessage.isSameTypeOf(message)) {
            currentMessage = currentMessage.accumulate(message);
        } else {
            saver.save(currentMessage.getDecoratedMessage());
            currentMessage = message;
        }
    }
}
