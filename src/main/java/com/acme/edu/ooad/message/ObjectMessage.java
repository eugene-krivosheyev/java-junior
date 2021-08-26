package com.acme.edu.ooad.message;

public class ObjectMessage {
    protected final String prefix;
    private final Object value;

    public String getPrefix() {
        return prefix;
    }

    protected ObjectMessage(String prefix) {
        this.prefix = prefix;
        this.value = null;
    }

    public ObjectMessage(Object value) {
        this.prefix = "reference: ";
        this.value = value;
    }

    public void clean() {};
    public String toString() {
        return prefix + value;
    }
}
