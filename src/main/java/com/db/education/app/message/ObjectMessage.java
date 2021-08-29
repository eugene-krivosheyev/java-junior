package com.db.education.app.message;

public class ObjectMessage implements Message {

    private final String TYPE = "OBJECT";

    private Object body;

    public ObjectMessage(Object body) {
        this.body = body;
    }

    @Override
    public ObjectMessage accumulate(Message message) {
        return this;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public String toString() {
        return "reference: " + body + System.lineSeparator();
    }
}
