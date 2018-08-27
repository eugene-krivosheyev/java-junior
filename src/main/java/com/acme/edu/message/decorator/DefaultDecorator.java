package com.acme.edu.message.decorator;

public class DefaultDecorator extends Decorator {
    private String type;

    @Override
    public String getDecoratedMessage() {
        return String.format("%s: %s%s", type, this.getMessage(), System.lineSeparator());
    }

    public DefaultDecorator(String type) {
        this.type = type;
    }

}
