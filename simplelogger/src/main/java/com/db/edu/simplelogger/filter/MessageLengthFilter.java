package com.db.edu.simplelogger.filter;

public class MessageLengthFilter implements Filter<String> {

    private final long limit;

    public MessageLengthFilter(long limit) {
        this.limit = limit;
    }

    public boolean filter(String message) {
        return message != null && message.length() < limit;
    }
}
