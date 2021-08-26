package com.db.edu.message;

import static com.db.edu.Prefix.PRIMITIVE_PREFIX;

public class BooleanMessage extends Message {

    private boolean message;

    public BooleanMessage(boolean message) {
        super(message);
        this.message = message;
    }

    @Override
    public void flush() {
        saver.save(PRIMITIVE_PREFIX.body + message);
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof BooleanMessage;
    }
}
