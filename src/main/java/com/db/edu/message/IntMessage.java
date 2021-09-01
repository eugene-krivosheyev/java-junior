package com.db.edu.message;

import com.db.edu.State;
import static com.db.edu.Logger.PRIMITIVE_PREFIX;

public class IntMessage implements Message {
    private Integer value;

    public IntMessage(Integer value) {
        this.value = value;
    }

    @Override
    public Message accumulate(Message message) {
        try {
            return new IntMessage(value += Integer.parseInt(message.getValue()));
        } catch (NullPointerException e) {
            return new IntMessage(value);
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
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public boolean isNotEmpty() {
        return value != null;
    }

    public Message flush() {
        return new IntMessage(null);
    }

    @Override
    public boolean isStateNotEquals(Message message) {
        return !isStateEquals(message);
    }
}








