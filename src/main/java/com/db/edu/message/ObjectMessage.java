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
    public Message accumulate(Message message) {
        return new ObjectMessage(value);
    }

    @Override
    public boolean isStateEquals(Message message) {
        return false;
    }

    @Override
    public State getState() {
        return State.OBJECT;
    }

    @Override
    public boolean isStateNotEquals(Message message) {
        return !isStateEquals(message);
    }
}
