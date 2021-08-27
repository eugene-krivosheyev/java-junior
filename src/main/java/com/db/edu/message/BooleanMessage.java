package com.db.edu.message;

import static com.db.edu.message.Prefix.PRIMITIVE_PREFIX;

public class BooleanMessage extends Message {

    private final boolean message;

    public BooleanMessage(boolean message) {
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
        return PRIMITIVE_PREFIX.body + message;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof BooleanMessage;
    }
}
