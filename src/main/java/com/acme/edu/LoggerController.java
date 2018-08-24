package com.acme.edu;

import com.acme.edu.message.Message;

public class LoggerController {

    private Message currentMessage;
    private LoggerSaver saver;

    public void log(Message message) {
        saver = new LoggerSaver();
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
