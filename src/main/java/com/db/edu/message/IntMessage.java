package com.db.edu.message;

import com.db.edu.Message;

public class IntMessage extends Message {
    private static final String PREFIX_PRIMITIVE = "primitive";
    private int body;

    public IntMessage(int message) {
        this.body = message;
    }

    public int getBody() {
        return body;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX_PRIMITIVE + ": " + body;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public IntMessage accumulate(Message message) {
        body += ((IntMessage)message).getBody();
        return this;
    }

    @Override
    public void resetFields() {
        body = 0;
    }
}
