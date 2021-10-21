package com.acme.edu.message;

public abstract class NumberMessage extends Message {

    public void process(Message message) {
        this.accumulate(message);
    }

    public abstract Number getValue();

    public abstract void accumulate(Message message);

    public String decorate() {
        return "primitive: " + this.getValue();
    }

}
