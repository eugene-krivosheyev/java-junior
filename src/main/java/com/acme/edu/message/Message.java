package com.acme.edu.message;

public class Message {
    enum Type {
        STRING,
        INT,
        CHAR,
        REFERENCE,
        BYTE,
        INT_ARRAY,
        INT_MATRIX,
        DEFAULT
    }

    private final Type type;
    protected String body = "";

    public Message(Type type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public boolean equalsMessage(Message message) {
        return type.equals(message.type);
    }
}
