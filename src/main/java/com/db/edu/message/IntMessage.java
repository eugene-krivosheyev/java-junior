package com.db.edu.message;

import static com.db.edu.Prefix.PRIMITIVE_PREFIX;

public class IntMessage extends Message {

    private final int message;
    private int intResult;

    public IntMessage(int message) {
        super(message);
        this.message = message;
    }

    @Override
    public void flush() {
        while (intResult > Integer.MAX_VALUE) {
            intResult -= Integer.MAX_VALUE;
            saver.save(PRIMITIVE_PREFIX.body + Integer.MAX_VALUE);
        }
        while (intResult < Integer.MIN_VALUE) {
            intResult -= Integer.MIN_VALUE;
            saver.save(PRIMITIVE_PREFIX.body + Integer.MIN_VALUE);
        }
        saver.save(PRIMITIVE_PREFIX.body + intResult);
        intResult = 0;
    }

    @Override
    public IntMessage accumulate(Message message) {
        if (!(message instanceof IntMessage)) {
            flush();
        }
        intResult += (int)message.getMessage();
        return this;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof IntMessage;
    }
}
