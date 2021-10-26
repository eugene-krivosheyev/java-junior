package com.acme.edu.message;

public class ObjectMessage extends Message {

    private Object value;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }

    @Override
    public void process(Message message) {
        System.out.println("Unreachable output ...");
    }

    @Override
    public String decorate() {
        return "reference: " + value;
    }
}
