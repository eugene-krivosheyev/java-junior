package com.db.education.app.controller;

import com.db.education.app.message.EmptyMessage;
import com.db.education.app.message.Message;
import com.db.education.app.saver.Saver;

public class LoggerController {

    private static final Message EMPTY_MESSAGE = new EmptyMessage();

    private final Saver saver;
    private Message lastMessage = EMPTY_MESSAGE;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void accept(Message message) {
        processMessage(message);
    }

    public void flush() {
        flushMessage();
    }

    private void processMessage(Message message) {
        if (message == null || message.isEmptyMessage()) {
            throw new IllegalArgumentException("Empty or null message received");
        }

        lastMessage = lastMessage.accumulate(message);

        if (lastMessage.needsFlush()) {
            Message last = lastMessage;
            flush();
            if (!(message == last)) {
                lastMessage = lastMessage.accumulate(message);
            }
        }
    }

    private void flushMessage() {
        if (lastMessage.isEmptyMessage()) return;

        saver.save(lastMessage);
        lastMessage = EMPTY_MESSAGE;
    }
}
