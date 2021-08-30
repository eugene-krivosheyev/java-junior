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
    }

    public void flush() {
        if (accumulateMessage != null) {
            try {
                saver.save(accumulateMessage.decorate());
            } catch (IOException e) {
                System.out.println("Can't save log");
            }
            accumulateMessage = emptyMessage;
        }
    }

    public void log(Message message) {
        try {
            if (!message.sameTypeOf(accumulateMessage)) {
                flush();
                accumulateMessage = message;
            } else {
                accumulateMessage = accumulateMessage.accumulate(message);
            }
        } catch (NullPointerException ex) {
            throw new NullPointerException("Message shouldn't be null");
        }
    }
}
