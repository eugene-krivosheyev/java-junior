package com.acme.edu.message;

public class IntegerMessage extends NumberMessage {

    private Long value;

    public IntegerMessage(Integer value) {
        this.value = (long) value;
    }

    public Long getValue() {
        return value;
    }

    public void accumulate(Message message) {
        IntegerMessage integerMessage = (IntegerMessage) message;
        this.value += integerMessage.getValue();
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntegerMessage;
    }

}
