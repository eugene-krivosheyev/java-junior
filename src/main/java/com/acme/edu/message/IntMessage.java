package com.acme.edu.message;

public class IntMessage implements Message {
    private int message;

    public IntMessage(int message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        IntMessage downcastedMessage = (IntMessage) nextMessage;
        return new IntMessage(this.message + downcastedMessage.message);
    }

    @Override
    public String getDecoratedMessage() {
        return String.format("%s: %d%s", "primitive", message, System.lineSeparator());
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }
}
