package com.db.edu.message;

import com.db.edu.Types;

public class CharMessage {
    private final char body;

    public CharMessage(char message) {
        this.body = message;
    }

    public String getDecoratedMessage() {
        return Types.PREFIX_CHAR + ": " + body;
    }
}
