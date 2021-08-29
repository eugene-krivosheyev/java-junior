package com.db.edu.messagepack.message;

public class ObjectMessage extends Message {
    private static final String PREFIX_REFERENCE = "reference";
    private final Object body;

    public ObjectMessage(Object message) {
        this.body = message;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX_REFERENCE + ": " + body;
    }
}
