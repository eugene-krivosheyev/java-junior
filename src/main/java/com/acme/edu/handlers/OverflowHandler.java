package com.acme.edu.handlers;

import com.acme.edu.messages.Message;

public abstract class OverflowHandler {
    long negative;
    long positive;
    long currentSum = 0;

    public String handleOverflow(long add) {
        currentSum += add;
        if (currentSum > positive) {
            currentSum -= positive;
            return String.valueOf(positive);
        } else if (currentSum < negative) {
            currentSum -= negative;
            return String.valueOf(negative);
        } else {
            return null;
        }
    }

    public void clear() {
        currentSum = 0;
    }

    public abstract Message getMessage();
}
