package com.db.education.app.message;

public class ObjectMessage implements Message{
    private Object value;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String toString() {
        return "reference: " + value + System.lineSeparator();
    }
}
