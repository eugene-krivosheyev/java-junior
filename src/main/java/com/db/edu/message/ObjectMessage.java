package com.db.edu.message;

import com.db.edu.State;

public class ObjectMessage implements Message {
    public static final String REFERENCE_PREFIX = "reference: ";
    private Object value = null;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public String decorated() {
        return REFERENCE_PREFIX + value;
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
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public boolean isStateEquals(State state) {
        return state.equals(State.OBJECT);
    }

    @Override
    public State getState() {
        return State.OBJECT;
    }
}
