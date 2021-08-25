package com.db.edu.message;

import static com.db.edu.Controller.flush;
import static com.db.edu.Prefix.PRIMITIVE_PREFIX;

public class IntMessage extends Message<Integer> {
    private int message;

    private static long intResult;

    public IntMessage(int message) {
        this.message = message;
    }

    public static void flushInt() {
        while (intResult > Integer.MAX_VALUE) {
            intResult -= Integer.MAX_VALUE;
            saver.save(PRIMITIVE_PREFIX.getMessage() + Integer.MAX_VALUE);
        }
        while (intResult < Integer.MIN_VALUE) {
            intResult -= Integer.MIN_VALUE;
            saver.save(PRIMITIVE_PREFIX.getMessage() + Integer.MIN_VALUE);
        }
        saver.save(PRIMITIVE_PREFIX.getMessage() + intResult);
        intResult = 0;
    }

    @Override
    public IntMessage accumulate(Message message) {
        if (!(message instanceof IntMessage)) {
            flush();
        }
        intResult += (long)message.getMessage();
        return this;
    }
}
