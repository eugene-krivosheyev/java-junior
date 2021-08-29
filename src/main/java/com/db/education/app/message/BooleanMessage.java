package com.db.education.app.message;

public class BooleanMessage implements Message {

    private final String TYPE = "BOOL";
    private boolean body;

    public BooleanMessage(boolean body) {
        this.body = body;
    }

    @Override
    public BooleanMessage accumulate(Message message) {
        return this;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public String toString() {
        return "primitive: " + body + System.lineSeparator();
    }
}
