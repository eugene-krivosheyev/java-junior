package com.acme.edu.decorator;

import com.acme.edu.message.Message;

public abstract class DecoratorVisitor {
    public String visit(Message message) {
        String decoratedMessage = message.accept(this);
        return decoratedMessage;
    }
    public abstract String decorateInt(int message);
    public abstract String decorateByte(byte message);
    public abstract String decorateChar(char message);
    public abstract String decorateString(String message);
    public abstract String decorateObject(Object message);
    public abstract String decorateBoolean(boolean message);
}