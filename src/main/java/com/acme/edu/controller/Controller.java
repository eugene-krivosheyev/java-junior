package com.acme.edu.controller;

import com.acme.edu.exception.LogException;
import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;

public class Controller {

    private final Saver saver;

    private Message messageBuffer;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (message == null) throw new LogException("Received message is null");

        if (messageBuffer == null) {
            messageBuffer = message;
        } else if (messageBuffer.canAppend(message)) {
            messageBuffer = messageBuffer.append(message);
        } else {
            flush();
            messageBuffer = message;
        }
    }

    public void flush() {
        saver.save(messageBuffer.getBody());
        messageBuffer = null;
    }
}