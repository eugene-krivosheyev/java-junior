package com.acme.edu.api.message;

public abstract class Message {
    private String prefix;
    private String value;

    public String getPrefix() {
        return prefix;
    }

    protected void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    protected void setValue(String value) {
        this.value = value;
    }

    protected String getValue() {
        return value;
    }

    public String getMessageAsString() {
        return prefix + value;
    }

    public Message accumulate(Message message) {
        return message;
    }

    abstract public boolean typeEquals(Message message);
}