package com.acme.edu;

public interface CommandMessage {
    public void accumulate();
    public void flush();
    public String getter();
}
