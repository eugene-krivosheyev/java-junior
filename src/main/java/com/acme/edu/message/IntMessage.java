package com.acme.edu.message;

public class IntMessage implements Message {
    private static final String PRIMITIVE = "primitive: ";
    private int message;

    private int getMessage() {
        return message;
    }

    public IntMessage(int message) {
        this.message = message;
    }

    public boolean isSameTypeOf(Message comparedMessage){
        return  (comparedMessage instanceof ByteMessage);
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE + this.message;
    }

    @Override
    public Message accumulate(Message message) {
        IntMessage intMessage = (IntMessage) message;
        this.message += intMessage.getMessage();
        return this;
    }
}
