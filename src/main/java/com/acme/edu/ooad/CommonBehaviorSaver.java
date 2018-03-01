package com.acme.edu.ooad;

public abstract class CommonBehaviorSaver {
    abstract void save(String message);

    protected boolean isEmpty(String message) {
        return message == null || message.equals("");
    }
}
