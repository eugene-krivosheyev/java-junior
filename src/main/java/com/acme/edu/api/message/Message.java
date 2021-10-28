package com.acme.edu.api.message;

public abstract class Message {
    private String prefix;
    private String value;

    public String getMessageAsString() {
        return prefix + value;
    }

    public Message accumulate(Message message) throws NullMessageException {
        return message;
    }

    abstract public boolean typeEquals(Message message);

    protected void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    protected void setValue(String value) {
        this.value = value;
    }

    protected String getValue() {
        return value;
    }

    protected String getPrefix() {
        return prefix;
    }
}