package com.acme.edu.message.decorator;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.loggerexceptions.LoggerErrors;

import static java.util.Objects.isNull;

public class DefaultDecorator extends Decorator {
    private String type;

    @Override
    public String getDecoratedMessage() {
        return String.format("%s: %s%s", type, this.getMessage(), System.lineSeparator());
    }

    public DefaultDecorator(String type) throws LoggerDecoratorException {
        if (isNull(type) || type.isEmpty()) {
            throw new LoggerDecoratorException("empty type", LoggerErrors.NULL_INPUT_TYPE);
        }
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
