package com.db.edu;

import com.db.edu.saver.Saver;
import com.db.edu.messagepack.message.EmptyMessage;
import com.db.edu.messagepack.message.Message;

public class Controller {
    private Message previousMessage = new EmptyMessage();
    private Saver saver;

    public Controller(Saver saver) {
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
