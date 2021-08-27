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
        return String.valueOf(value);
    }

    @Override
    public void flush() {
    }

    @Override
    public void accumulate() {
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public boolean isStateEquals(State state) {
        return state.equals(State.BOOLEAN);
    }

    @Override
    public State getState() {
        return State.BOOLEAN;
    }
}
