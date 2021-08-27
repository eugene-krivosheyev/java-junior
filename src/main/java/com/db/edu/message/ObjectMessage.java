package com.db.edu.message;

import static com.db.edu.Prefix.CHAR_PREFIX;
import static com.db.edu.Prefix.OBJECT_PREFIX;

public class ObjectMessage extends Message{
    private final Object message;

    public ObjectMessage(Object message) {
        super(message);
        this.message = message;
    }

    @Override
    public void flush() {
        saver.save(decorate(message));
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public String decorate(Object message) {
        return OBJECT_PREFIX.body + message;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof ObjectMessage;
    }
}
