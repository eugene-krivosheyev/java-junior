package com.acme.edu.decorateComands;

import static com.acme.edu.LoggerType.PRIMITIVE;

public class PrimitiveDecorateCommand implements DecorateCommand {
    private String message;

    public PrimitiveDecorateCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return PRIMITIVE.getType() + message;
    }
}
