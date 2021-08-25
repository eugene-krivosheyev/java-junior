package com.db.edu;

import static com.db.edu.Controller.flush;
import static com.db.edu.Prefix.PRIMITIVE_PREFIX;

public class IntMessage {
    private int message;
    private static long intResult;

    public IntMessage(int message) {
        this.message = message;
    }

    public void createMessage() {

    }

    static void flushInt() {
        while (intResult > Integer.MAX_VALUE) {
            intResult -= Integer.MAX_VALUE;
            ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + Integer.MAX_VALUE);
        }
        while (intResult < Integer.MIN_VALUE) {
            intResult -= Integer.MIN_VALUE;
            ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + Integer.MIN_VALUE);
        }
        ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + intResult);
        intResult = 0;
    }

    Object accumulate(Object type) {
        if (!(type instanceof Integer)) {
            flush();
            type = message;
        }
        intResult += message;
        return type;
    }
}
