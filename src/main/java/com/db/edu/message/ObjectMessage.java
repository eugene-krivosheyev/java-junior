package com.db.edu.message;

import com.db.edu.Types;

public class ObjectMessage {
    private final Object body;

    public ObjectMessage(Object message) {
        this.body = message;
    }

    public String getDecoratedMessage() {
        return Types.PREFIX_REFERENCE + ": " + body;
    }
}
