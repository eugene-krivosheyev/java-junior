package com.acme.edu.comands;

import static com.acme.edu.LoggerType.PRIMITIVE;

public class PrimitiveCommand implements Command {
    private String message;
    private Integer[] messages;

    public PrimitiveCommand(Integer[] messages) {
        this.messages = messages;
    }

    public PrimitiveCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return PRIMITIVE.getType() + message;
    }
}
