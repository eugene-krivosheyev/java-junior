package com.db.ooad;

public class MessageLengthFilter implements LoggerFilter {

    private int msgLength;

    void MessageLengthFilter(int msgLength){
        this.msgLength = msgLength;
    }
    @Override
    public boolean filter(String message) {
        boolean result;

        result = (msgLength >= message.length()) ? true : false;
        return result;
    }
}
