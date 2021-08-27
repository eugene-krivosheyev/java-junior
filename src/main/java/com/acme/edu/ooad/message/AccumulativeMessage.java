package com.acme.edu.ooad.message;

public interface AccumulativeMessage extends Message {
    public static boolean isAccumulative(Message message) {
        return AccumulativeMessage.class.isAssignableFrom(message.getClass());
    }
}
