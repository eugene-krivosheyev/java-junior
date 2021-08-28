package com.db.edu.message;

import com.db.edu.Message;

public class CharMessage extends Message {
    private static final String PREFIX_CHAR = "char";
    private final char body;

    public CharMessage(char message) {
        this.body = message;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX_CHAR + ": " + body;
    }


}
