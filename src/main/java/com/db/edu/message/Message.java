package com.db.edu.message;

import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.Saver;

public abstract class Message {
    private final Object message;

    private final Saver saver;

    public Message(Object message, Saver saver) {
        this.message = message;
        this.saver = saver;
    }

    public Object getMessage() {
        return message;
    }

    public abstract void flush();

    public abstract Message accumulate(Message message);

    public abstract String decorate(Object message);

    public abstract boolean sameTypeOf(Message accumulateMessage);
}
