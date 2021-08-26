package com.acme.edu.ooad.message;

public class AccumulatedMessage extends ObjectMessage {
    public AccumulatedMessage(String prefix) {
        super(prefix);
    };
    //public void process(){};
    public static boolean isAncestor(ObjectMessage message) {
        return AccumulatedMessage.class.isAssignableFrom(message.getClass());
    }
}
