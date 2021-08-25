package com.acme.edu.messages;

public class ObjectMessage extends Message{
    private Object value;

    public ObjectMessage(Object message) {
        super(message);
        this.value = message;
    }

    @Override
    public String wrapMessage() {
        return this.message_type + ": " + this.value;
    }
}
