package com.db.edu.message;

import static com.db.edu.message.Prefix.PRIMITIVE_PREFIX;

public class IntMessage extends Message {

    private int intResult;

    public IntMessage(int message) {
        super(message);
        intResult = message;
    }

    @Override
    public IntMessage accumulate(Message message) {
        if (!sameTypeOf(message)) {
            flush();
            return this;
        }
        intResult += (int) message.getMessage();
        return this;
    }

    @Override
    public String decorate() {
        return PRIMITIVE_PREFIX.body + intResult;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof IntMessage;
    }

    private void flush() {
        intResult = 0;
    }
}
