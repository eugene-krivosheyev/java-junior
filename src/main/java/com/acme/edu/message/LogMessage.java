package com.acme.edu.message;

public abstract class LogMessage {
    Object value;

    public String getDecoratedSelf;

    public abstract String getDecoratedSelf();

    public abstract void reset(); // static
}
