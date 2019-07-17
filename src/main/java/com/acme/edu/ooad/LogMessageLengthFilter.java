package com.acme.edu.ooad;

import java.util.Objects;

public class LogMessageLengthFilter implements LogFilter {
    private int maxMessageLength;

    public LogMessageLengthFilter(int maxMessageLength) {
        this.maxMessageLength = maxMessageLength;
    }

    @Override
    public boolean allow(String message) {
        if(message == null) throw new IllegalArgumentException();

        return message.length() <= maxMessageLength;
    }
}
