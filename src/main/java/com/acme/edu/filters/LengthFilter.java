package com.acme.edu.filters;

import com.acme.edu.messages.Message;

public class LengthFilter implements Filter {
    private final int lengthLimit;

    public LengthFilter(int lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    @Override
    public boolean filter(Message message) {
        return (message.getValue().toString().length() > lengthLimit);
    }
}
