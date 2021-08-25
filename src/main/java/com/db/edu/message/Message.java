package com.db.edu.message;

import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.Saver;

public abstract class Message<T> {
    static Saver saver = new ConsoleSaver();
    private T message;

    public T getMessage() {
        return message;
    }

    abstract public Message accumulate(Message message);
}
