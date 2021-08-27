package com.acme.edu.filters;

import com.acme.edu.messages.Message;

public class LengthFilter implements Filter {
    private final int lengthLimit;

    public LengthFilter(int lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    @Override
    public boolean filter(Message message) throws IllegalAccessException {
        if (message == null)
            throw new IllegalAccessException("message is null");

        if (message.getValue().toString().length() == 0)
            throw new IllegalAccessException("message is empty");

        return (message.getValue().toString().length() > lengthLimit);
    }
}
