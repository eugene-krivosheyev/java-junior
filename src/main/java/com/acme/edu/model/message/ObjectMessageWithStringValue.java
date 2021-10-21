package com.acme.edu.model.message;

public class ObjectMessageWithStringValue extends UnableToJoinMessageWithStringValue {
    public ObjectMessageWithStringValue(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return "reference: " + getStringValue();
    }

}
