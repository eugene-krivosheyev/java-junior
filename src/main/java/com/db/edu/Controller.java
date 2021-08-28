package com.db.edu;

import com.db.edu.message.EmptyMessage;

public class Controller {
    private Message previousMessage = new EmptyMessage();
    private ConsoleSaver saver;

    public Controller(ConsoleSaver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (previousMessage.isSameType(message)) {
            previousMessage = previousMessage.accumulate(message);
        } else {
            flush();
            previousMessage = message;
        }
    }

    public void flush() {
        saver.save(previousMessage);
        previousMessage.resetFields();
    }
}
