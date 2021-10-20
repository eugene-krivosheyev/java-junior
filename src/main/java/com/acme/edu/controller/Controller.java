package com.acme.edu.controller;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.Saver;

public class Controller {

    private final Saver saver = new Saver();

    private Message messageBuffer;

    public void perform(IntMessage message) {
        if (messageBuffer == null) {
            messageBuffer = message;
        } else if (messageBuffer.equalsMessage(message)) {
            IntMessage buffer = (IntMessage) messageBuffer;
            buffer.addToMessage(message);
            if (buffer.isOverflow()) {
                flush();
            }
        } else {
            flush();
            messageBuffer = message;
        }
    }

    public void perform(StringMessage message) {
        if (messageBuffer == null) {
            messageBuffer = message;
        } else if (messageBuffer.equalsMessage(message)) {
            StringMessage buffer = (StringMessage) messageBuffer;
            buffer.addToMessage(message);
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
