package com.db.edu.message;

import com.db.edu.State;

import static com.db.edu.Logger.CHAR_PREFIX;

public class CharMessage implements Message {
    private Character value = null;

    public CharMessage(Character value) {
        this.value = value;
    }

    @Override
    public String decorated() {
        return CHAR_PREFIX + value;
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
        return state.equals(State.CHAR);
    }

    @Override
    public State getState() {
        return State.CHAR;
    }
}
