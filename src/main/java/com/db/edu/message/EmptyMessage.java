package com.db.edu.message;

import com.db.edu.State;

public class EmptyMessage implements Message {
    @Override
    public String decorated() {
        return null;
    }

    @Override
    public boolean isNotEmpty() {
        return false;
    }

    @Override
    public String getValue() {
        return null;
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
        return false;
    }

    @Override
    public State getState() {
        return State.EMPTY;
    }
}
