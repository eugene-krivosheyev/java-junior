package com.db.edu.message;

import com.db.edu.State;
import static com.db.edu.Logger.PRIMITIVE_PREFIX;

public class IntMessage implements Message {
    private Integer value;

    public IntMessage(int value) {
        this.value = value;
    }

    @Override
    public boolean accumulate(Message message) {
        value += Integer.parseInt(message.getValue());
        return true;
    }

    @Override
    public boolean isStateEquals(State state) {
        return state.equals(State.INT);
    }

    @Override
    public State getState() {
        return State.INT;
    }

    @Override
    public String decorated() {
        return PRIMITIVE_PREFIX + value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public boolean isNotEmpty() {
        return value != null;
    }

    @Override
    public void flush() {
        value = 0;
    }

    @Override
    public void accumulate() {

    }
}








