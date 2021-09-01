package com.db.edu;

import com.db.edu.message.*;
import com.db.edu.saver.Saver;

import java.io.IOException;


public class Controller {
    private Message accumulateMessage;
    private final Message emptyMessage;
    private final Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
        this.emptyMessage = new EmptyMessage();
        this.accumulateMessage = emptyMessage;
    }

    public void flush() {
        if (accumulateMessage != emptyMessage) {
            try {
                saver.save(accumulateMessage.decorate());
            } catch (LoggerException e) {
                System.out.println("Can't save log");
            }
            accumulateMessage = emptyMessage;
        }
    }

    public void log(Message message) throws LoggerException {
        try {
            if (!message.sameTypeOf(accumulateMessage)) {
                flush();
                accumulateMessage = message;
            } else {
                accumulateMessage = accumulateMessage.accumulate(message);
            }
        } catch (NullPointerException ex) {
            throw new LoggerException("Message shouldn't be null", ex);
        }
    }
}
