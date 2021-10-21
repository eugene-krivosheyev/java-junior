package com.acme.edu;

import com.acme.edu.message.Message;

public class ByteStrategy implements Strategy {

    @Override
    public boolean isSameType(Message message) {
        return message.getStrategy() instanceof ByteStrategy;
    }
}
