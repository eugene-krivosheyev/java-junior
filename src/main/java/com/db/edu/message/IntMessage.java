package com.db.edu.message;

import com.db.edu.State;
import static com.db.edu.Logger.PRIMITIVE_PREFIX;

public class IntMessage implements Message {
    private Integer value;

    public IntMessage(int value) {
        this.value = value;
    }

    @Override
    public Message accumulate(Message message) {
        if (message.getValue() == null) {
            return new IntMessage(value);
        } else {
            return new IntMessage(value += Integer.parseInt(message.getValue()));
        }
    }

    @Override
    public boolean isStateEquals(Message message) {
        return message.getState().equals(State.INT);
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
    public boolean isStateNotEquals(Message message) {
        return !isStateEquals(message);
    }
}








