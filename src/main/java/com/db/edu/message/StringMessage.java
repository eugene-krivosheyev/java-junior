package com.db.edu.message;

public class StringMessage {

    private static final String STRING_PREFIX = "string: ";
    private int quantityString = 0;
    private String value;

    public StringMessage(String value) {
        this.value = value;
    }

    public void accumulate(StringMessage message) {
        this.value = message.getValue();
        ++quantityString;
    }

    public String decoratedString() {
        if (quantityString == 1) {
            return STRING_PREFIX + value;
        } else {
            return STRING_PREFIX + value + " (x" + quantityString + ")";
        }
    }

    public boolean isMessageEquals(StringMessage message) {
        return message.getValue().equals(value);
    }

    public boolean isEmpty() {
        return quantityString == 0;
    }

    public void flush() {
        value = null;
        quantityString = 0;
    }

    public String getValue() {
        return value;
    }

}