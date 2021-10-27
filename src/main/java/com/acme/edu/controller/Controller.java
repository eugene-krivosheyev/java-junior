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
        if (message == null) throw new IllegalArgumentException("Received message is null");

        if (messageBuffer == null) {
            messageBuffer = message;
        } else if (messageBuffer.canAppend(message)) {
            Message[] messageArray = messageBuffer.append(message);
            flushAllOverflowingMessages(messageArray);
            messageBuffer = messageArray[messageArray.length - 1];
        } else {
            flush();
            messageBuffer = message;
        }
    }

    public void flush() {
        saver.save(messageBuffer.getBody());
        messageBuffer = null;
    }

    private void flushAllOverflowingMessages(Message[] messageArray) {
        for (int i = 0; i < messageArray.length - 1; i++) {
            messageBuffer = messageArray[i];
            flush();
        }
    }
}