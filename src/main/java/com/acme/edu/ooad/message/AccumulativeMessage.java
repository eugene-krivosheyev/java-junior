package com.acme.edu.ooad.message;

public class AccumulativeMessage extends ObjectMessage {
    public AccumulativeMessage(String prefix) {
        super(prefix);
    };
    //public void process(){};
    public static boolean isAncestor(ObjectMessage message) {
        return AccumulativeMessage.class.isAssignableFrom(message.getClass());
    }
}
