package com.db.education.app.message;

import java.util.Objects;

public class StringMessage implements Message{
    private final MessageType type = MessageType.STRING;
    private String value;
    private int count;

    public StringMessage(String value) {
        this.value = value;
        count = 1;
    }

    /**
     * Counts equal strings
     * */
    @Override
    public boolean accumulate(Message message) {
        if (!typeEquals(message)) return false;
        if(Objects.equals(value, ((StringMessage)message).value)) {
            ++count;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String countString = (count > 1) ? " (x" + count + ")" : "";
        return "string: " + value + countString + System.lineSeparator();
    }

    @Override
    public MessageType getType() {
        return type;
    }

    @Override
    public boolean typeEquals(Message otherMessage) {
        return this.type.equals(otherMessage.getType());
    }
}
