package com.db.edu.messagepack.message;

public class BooleanMessage extends Message {
    private static final String PREFIX_PRIMITIVE = "primitive";
    private final boolean body;

    public BooleanMessage(boolean message) {
        this.body = message;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX_PRIMITIVE + ": " + body;
    }
}
