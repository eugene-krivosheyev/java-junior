package com.acme.edu;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Message previousMessage = null;
    private Saver saver;
    public LoggerController(Message message, Saver saver, Decorator decorator) {
        this.previousMessage = previousMessage;
        this.saver = saver;
    }
    public void log(Message message) throws Exception {
        if (previousMessage == null) {
            previousMessage = message;
        }
        else if (message.isSameTypeOf(previousMessage)) {
            previousMessage.accumulate(message);
        } else {
            saver.save(previousMessage.fetch());
            previousMessage = message;
        }
    }
}
