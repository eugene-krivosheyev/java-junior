package com.acme.edu.ooad.message;

public class ObjectMessage {
    private final String prefix;
    private final Object value;

    protected String getPrefix() {
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

    public void clean() {}
    public String toString() {
        return prefix + value;
    }
}
