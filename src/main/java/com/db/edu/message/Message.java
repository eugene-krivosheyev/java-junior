package com.db.edu.message;

import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.Saver;

public abstract class Message {
    private final Object message;

    public Message(Object message) {
        this.message = message;
    }

    static Saver saver = new ConsoleSaver();

    public Object getMessage() {
        return message;
    }

    public abstract void flush();

    public abstract Message accumulate(Message message);

    public abstract String decorate(Object message);

    public abstract boolean sameTypeOf(Message accumulateMessage);
}
