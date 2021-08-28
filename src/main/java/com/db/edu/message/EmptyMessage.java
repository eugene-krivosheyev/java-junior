package com.db.edu.message;

import com.db.edu.Message;

public class EmptyMessage extends Message {
    @Override
    public String getDecoratedMessage() {
        return null;
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public boolean isSameType(Message message) {
        return true;
    }
}
