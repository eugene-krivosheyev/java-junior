package com.db.edu.message;

import com.db.edu.State;
import static com.db.edu.Logger.REFERENCE_PREFIX;

public class ObjectMessage implements Message {
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
    public void accumulate() {

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
