package com.db.edu.message;

import com.db.edu.Message;
import com.db.edu.Types;

public class IntMessage extends Message {
    private int body;

    public IntMessage(int message) {
        this.body = message;
    }

    public String getDecoratedMessage() {
        return Types.PREFIX_PRIMITIVE + ": " + body;
    }

    public int getBody() {
        return body;
    }

    @Override
    public boolean isSameType(Message message) {
        return this.getState() == message.getState();
    }

    @Override
    public IntMessage accumulate(Message message) {
        IntMessage newMessage = (IntMessage)message;
        this.body += newMessage.getBody();
        return this;
    }
}
