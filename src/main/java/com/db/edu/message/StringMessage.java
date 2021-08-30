package com.db.edu.message;

import com.db.edu.State;
import static com.db.edu.Logger.STRING_PREFIX;

public class StringMessage implements Message {
    private int quantityOfRepetitiveString = 0;
    private final String value;

    public StringMessage(String value) {
        this.value = value;
    }

    @Override
    public Message accumulate(Message message) {
        StringMessage newMessage = new StringMessage(value);
        if (message instanceof StringMessage) {
            newMessage.setQuantityOfRepetitiveString(((StringMessage) message).getQuantityOfRepetitiveString() + 1);
        } else {
            newMessage.setQuantityOfRepetitiveString(1);
        }
        return newMessage;
    }

    @Override
    public boolean isStateEquals(Message message) {
        return message.getState().equals(State.STRING) && isMessageEquals(message);
    }

    @Override
    public State getState() {
        return State.STRING;
    }

    @Override
    public String decorated() {
        if (quantityOfRepetitiveString <= 1) {
            return STRING_PREFIX + value;
        } else {
            return STRING_PREFIX + value + " (x" + quantityOfRepetitiveString + ")";
        }
    }

    @Override
    public boolean isNotEmpty() {
        return value != null;
    }

    @Override
    public Message flush() {
        return new StringMessage(null);
    }

    @Override
    public String getValue() {
        if (value == null) {
            return null;
        } else {
            return value;
        }
    }

    @Override
    public boolean isStateNotEquals(Message message) {
        return !isStateEquals(message);
    }

    private int getQuantityOfRepetitiveString() {
        return quantityOfRepetitiveString;
    }

    private void setQuantityOfRepetitiveString(int quantityOfRepetitiveString) {
        this.quantityOfRepetitiveString = quantityOfRepetitiveString;
    }

    private boolean isMessageEquals(Message message) {
        return message.getValue().equals(value);
    }
}