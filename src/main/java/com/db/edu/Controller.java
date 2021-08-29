package com.db.edu;

import com.db.edu.message.*;
import com.db.edu.saver.Saver;


public class Controller {
    private Message accumulateMessage;
    private final Message emptyMessage;
    private final Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
        this.emptyMessage = new EmptyMessage();
    }

    public void flush() {
        if (accumulateMessage != null) {
            saver.save(accumulateMessage.decorate());
            accumulateMessage = emptyMessage;
        }
    }

    public void log(Message message) {
        if (!message.sameTypeOf(accumulateMessage)) {
            flush();
            accumulateMessage = message;
        } else {
            accumulateMessage = accumulateMessage.accumulate(message);
        }
    }
}
