package com.db.edu.message;

import static com.db.edu.message.Prefix.PRIMITIVE_PREFIX;

public class IntMessage extends Message {

    private int intResult;

    public IntMessage(int message) {
        super(message);
        intResult = message;
    }

    @Override
    public void flush() {
//        while (intResult > Integer.MAX_VALUE) {
//            intResult -= Integer.MAX_VALUE;
//            saver.save(decorate(Integer.MAX_VALUE));
//        }
//        while (intResult < Integer.MIN_VALUE) {
//            intResult -= Integer.MIN_VALUE;
//            saver.save(decorate(Integer.MIN_VALUE));
//        }
        saver.save(decorate(intResult));
        intResult = 0;
    }

    @Override
    public IntMessage accumulate(Message message) {
        if (!sameTypeOf(message)) {
            flush();
            return this;
        }
        intResult += (int)message.getMessage();
        return this;
    }

    @Override
    public String decorate(Object message) {
        return PRIMITIVE_PREFIX.body + message;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof IntMessage;
    }
}
