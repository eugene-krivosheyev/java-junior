package com.db.education.app;

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

    public void processMessage(Message message) {
        if (lastMessage.isEmpty()) {
            lastMessage = message;
            return;
        }

        if (!lastMessage.accumulate(message)) {
            flush();
            lastMessage = message;
        }
    }

    public void flush() {
        saver.save(lastMessage);
        lastMessage = EMPTY_MESSAGE;
    }
}
