package com.db.education.app;

import com.db.education.app.message.EmptyMessage;
import com.db.education.app.message.Message;
import com.db.education.app.saver.ConsoleSaver;

import java.util.Objects;

public class LoggerController {
    private final ConsoleSaver saver = new ConsoleSaver();
    private Message lastMessage = new EmptyMessage();

    public void processMessage(Message message) {
        if(Objects.equals(lastMessage.getClass(), EmptyMessage.class)) {
            lastMessage = message;
            return;
        }

        if (lastMessage.getClass() != message.getClass() || !lastMessage.accumulate(message)) {
            flush();
            lastMessage = message;
        }
    }

    public void flush() {
        saver.save(lastMessage);
        lastMessage = new EmptyMessage();
    }
}
