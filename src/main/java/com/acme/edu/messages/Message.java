package com.acme.edu.messages;

public class Message {
    protected String message_type;
    protected Object value;

    public Message(Object message) {
        if (message instanceof Character) {
            message_type = "char";
        } else if (message instanceof Integer) {
            message_type = "primitive";
        } else if (message instanceof Byte) {
            message_type = "primitive";
        } else if (message instanceof Boolean) {
            message_type = "primitive";
        } else if (message instanceof String) {
            message_type = "string";
        } else if (message instanceof Object) {
            message_type = "reference";
        }
    }

    public Object getValue() {
        if (value == null) throw new IllegalArgumentException("not valid message to log!");
        return value;
    };

    public String getType() {
        return message_type;
    }
}
