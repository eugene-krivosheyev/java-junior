package com.db.edu.message;

import com.db.edu.State;
import static com.db.edu.Logger.PRIMITIVE_PREFIX;

public class ByteMessage implements Message {
    private Byte value = null;

    public ByteMessage(Byte value) {
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
        return new ByteMessage(null);
    }

    @Override
    public Message accumulate(Message message) {
        return new ByteMessage(value);
    }

    @Override
    public boolean isStateEquals(Message message) {
        return false;
    }

    @Override
    public State getState() {
        return State.BYTE;
    }

    @Override
    public boolean isStateNotEquals(Message message) {
        return !isStateEquals(message);
    }
}
