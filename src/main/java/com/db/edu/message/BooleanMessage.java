package com.db.edu.message;

import com.db.edu.State;
import static com.db.edu.Logger.PRIMITIVE_PREFIX;

public class BooleanMessage implements Message {
    private final Boolean value;

    public BooleanMessage(Boolean value) {
        this.value = value;
    }

    @Override
    public String decorated() {
        return PRIMITIVE_PREFIX + value;
    }

    @Override
    public boolean isNotEmpty() {
        return value != null;
    }

    @Override
    public String getValue() {
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public Message flush() {
        return new BooleanMessage(null);
    }

    @Override
    public Message accumulate(Message message) {
        return new BooleanMessage(value);
    }

    @Override
    public State getState() {
        return State.BOOLEAN;
    }

    @Override
    public boolean isStateEquals(Message message) {
        return false;
    }

    @Override
    public boolean isStateNotEquals(Message message) {
        return !isStateEquals(message);
    }
}
