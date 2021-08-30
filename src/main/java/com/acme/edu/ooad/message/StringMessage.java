package com.acme.edu.ooad.message;

import java.util.Objects;

public class StringMessage implements Message {
    private final String prefix;
    private final String value;
    int counter;

    public StringMessage(String value) {
        this.prefix = "string: ";
        this.value = value;
        this.counter = 1;
    }

    StringMessage(String value, int counter) {
        this.prefix = "string: ";
        this.value = value;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return prefix + getBody();
    }

    @Override
    public void clean() {
        counter = 0;
    }

    boolean equalValues(Message message) {
        return Objects.equals(this.value, ((StringMessage)message).value);
    }

    @Override
    public Message getNewInstance(Message message) {
        if (Message.sameType(this, message) && this.equalValues(message)) {
            int newCounter = this.counter +1;
            return new StringMessage(this.value,newCounter);
        } else {
            return message;
        }
    }

    @Override
    public Message getInstanceToPrint(Message message) {
        if (Message.sameType(this, message) && this.equalValues(message)) return null;
        return this;
    }

    @Override
    public String getBody() {
        if ( counter == 0 || value == null ) return "";
        return value + (counter > 1 ? " (x" + counter + ")" : "");
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof StringMessage) {
            if ((this.value == ((StringMessage) anObject).value) &&
                (this.counter == ((StringMessage) anObject).counter)) {
                return true;
            }
        }
        return false;
    }

}
