package com.acme.edu;

import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;

import java.io.FileNotFoundException;

public class Controller {
    private Message currentMessage = null;
    private Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public Controller(Saver saver, Message currentMessage) {
        this.saver = saver;
        this.currentMessage = currentMessage;
    }

    public Message getCurrentMessage() {
        return currentMessage;
    }

    public void log(Message message) throws LogException {
        if (message.isSameType(currentMessage)) {
            currentMessage = message.accumulate(currentMessage);
        } else {
            if (currentMessage != null) {
                saver.save(currentMessage.decorate());
            }
            currentMessage = message;
        }
    }

    public void flush() throws LogException {
        if (currentMessage == null) {
            throw new LogException("There is nothing to flush", 1002);
        }
        saver.save(currentMessage.decorate());
        currentMessage = null;
    }
}