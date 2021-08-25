package com.db.education.app.message;

import java.util.Objects;

public class StringMessage implements Message{
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
}
