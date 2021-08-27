package com.db.edu.message;

import com.db.edu.Types;

public class BooleanMessage {
    private final boolean body;

    public BooleanMessage(boolean message) {
        this.body = message;
    }

    public String getDecoratedMessage() {
        return Types.PREFIX_PRIMITIVE + ": " + body;
    }
}
