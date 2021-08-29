package com.db.edu.messagepack.message;

public class StringMessage extends Message {
    private static final String PREFIX_STRING = "string";
    private String body;
    private int stringCounter = 1;

    public StringMessage(String message) {
        this.body = message;
    }

    @Override
    public String getDecoratedMessage() {
        String resString = PREFIX_STRING + ": " + body;
        if(stringCounter == 1) {
            return resString;
        }
        return resString + " (x" + stringCounter + ")";
    }

    @Override
    public StringMessage accumulate(Message message) {
        stringCounter++;
        return this;
    }

    @Override
    public boolean isSameType(Message message) {
        if (!(message instanceof StringMessage)) {
            return false;
        }

        StringMessage newMessage = (StringMessage)message;
        return body.equals(newMessage.body);
    }

    @Override
    public void resetFields() {
        stringCounter = 1;
    }
}