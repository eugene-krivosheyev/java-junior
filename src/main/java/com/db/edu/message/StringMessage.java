package com.db.edu.message;

import com.db.edu.State;
import static com.db.edu.Logger.STRING_PREFIX;

public class StringMessage implements Message {
    private int quantityOfRepetitiveString = 0;
    private String value;

    public StringMessage(String value) {
        this.value = value;
    }

    @Override
    public boolean accumulate(Message message) {
        if (isMessageEquals(message)) {
            this.value = message.getValue();
            ++quantityOfRepetitiveString;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isStateEquals(State state) {
        return state.equals(State.STRING);
    }

    @Override
    public State getState() {
        return State.STRING;
    }

    @Override
    public String decorated() {
        if (quantityOfRepetitiveString == 1) {
            return STRING_PREFIX + value;
        } else {
            return STRING_PREFIX + value + " (x" + quantityOfRepetitiveString + ")";
        }
    }

    public boolean isMessageEquals(Message message) {
        return message.getValue().equals(value);
    }

    @Override
    public boolean isNotEmpty() {
        return value != null;
    }

    @Override
    public void flush() {
        value = null;
        quantityOfRepetitiveString = 0;
    }

    @Override
    public void accumulate() {
        quantityOfRepetitiveString++;
    }

    @Override
    public String getValue() {
        return value;
    }

}