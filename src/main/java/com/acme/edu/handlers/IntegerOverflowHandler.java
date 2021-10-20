package com.acme.edu.handlers;

import com.acme.edu.messages.IntegerMessage;
import com.acme.edu.messages.Message;

public class IntegerOverflowHandler extends OverflowHandler {
    public IntegerOverflowHandler() {
        negative = Integer.MIN_VALUE;
        positive = Integer.MAX_VALUE;
    }

    @Override
    public Message getMessage() {
        return new IntegerMessage((int) currentSum);
    }
}
